package com.wbo112.scheduledemo;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Demo {
    private AtomicBoolean flag = new AtomicBoolean(false);
    private static ArrayBlockingQueue<TaskInfo> additionalQueue = new ArrayBlockingQueue(1024);

    private AtomicBoolean cancel = new AtomicBoolean(false);
    private static AtomicBoolean additionalStatus = new AtomicBoolean(false);
    private static ConcurrentLinkedDeque<TaskInfo> taskLinkedList = new ConcurrentLinkedDeque<>();
    static ScheduledThreadPoolExecutor scheduledTask;
    private static Map<TaskInfo, ScheduledFuture> scheduledFutureMap = new HashMap<>();
    static Thread additionalThread;

    static {
        scheduledTask = new ScheduledThreadPoolExecutor(10);
        Runnable additionalRunnable = () -> {
            if (!additionalStatus.compareAndSet(false, true)) {
                return;
            }
            while (true) {
                TaskInfo taskInfo = null;
                try {
                    taskInfo = additionalQueue.take();
                } catch (InterruptedException e) {

                }
                if (!additionalStatus.get()) {
                    return;
                }
                System.out.println("additional Task");
                taskInfo.r();
            }
        };
        additionalThread = new Thread(additionalRunnable);
        additionalThread.start();
    }

    private Demo() {

    }

    public static void main(String[] args) throws InterruptedException {
        LocalDateTime startTime = LocalDateTime.now();
        List<String> serverInfos = Arrays.asList("a", "b");
        TaskInfo taskInfo = new TaskInfo(serverInfos, startTime.atZone(ZoneOffset.systemDefault()).toEpochSecond(), startTime.plusMinutes(5).atZone(ZoneOffset.systemDefault()).toEpochSecond());
        new Demo().triggerCollect(taskInfo);
    }

    public boolean triggerCollect(TaskInfo taskInfo) {

        ScheduledFuture<?> scheduledFuture = scheduledTask.scheduleAtFixedRate(() -> {
            collect(taskInfo);

        }, 0, 1, TimeUnit.SECONDS);
        scheduledFutureMap.put(taskInfo, scheduledFuture);

        return true;
    }

    public void cancel(TaskInfo taskInfo) {
        ScheduledFuture scheduledFuture = scheduledFutureMap.remove(taskInfo);
        if (Objects.nonNull(scheduledFuture)) {
            scheduledFuture.cancel(true);
        }
        additionalQueue.remove(taskInfo);
    }

    public boolean stopTask() {
        additionalStatus.set(false);
        Runnable runnable1 = () -> {
            if (Objects.nonNull(scheduledTask)) {
                scheduledTask.shutdownNow();
                while (scheduledTask.isTerminated()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable1);
        Runnable runnable2 = () -> {
            if (Objects.nonNull(additionalThread)) {
                additionalThread.interrupt();
                while (additionalThread.isAlive()) {

                }
            }
        };
        Thread thread2 = new Thread(runnable2);
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void collect(TaskInfo taskInfo) {
        LocalDateTime startTime = LocalDateTime.now();
//        TaskInfo taskInfo = new TaskInfo(serverInfos, startTime.atZone(ZoneOffset.systemDefault()).toEpochSecond(), startTime.plusMinutes(5).atZone(ZoneOffset.systemDefault()).toEpochSecond());
        if (taskLinkedList.contains(taskInfo)) {
            additionalQueue.add(taskInfo);
            return;
        }

        try {
            taskLinkedList.add(taskInfo);

            System.out.println("start Collect Task"+LocalDateTime.now());
            taskInfo.r();
            System.out.println("finsh Collect Task");

        } finally {
            taskLinkedList.remove(taskInfo);
        }
    }


    private static class TaskInfo {
        private List<String> serverInfos;
        private long taskStartTime;
        private long taskEndTime;

        public TaskInfo(List<String> serverInfos, long taskStartTime, long taskEndTime) {
            this.serverInfos = serverInfos;
            this.taskStartTime = taskStartTime;
            this.taskEndTime = taskEndTime;
        }

        public void r()  {
            System.out.println(this);
            try {
                Thread.sleep(new Random().nextInt(10)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "TaskInfo{" +
                    "serverInfos=" + serverInfos +
                    ", taskStartTime=" + LocalDateTime.ofEpochSecond(taskStartTime, 0, OffsetDateTime.now ().getOffset()) +
                    ", taskEndTime=" + LocalDateTime.ofEpochSecond(taskEndTime, 0,OffsetDateTime.now ().getOffset()) +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TaskInfo taskInfo = (TaskInfo) o;
            return Objects.equals(serverInfos, taskInfo.serverInfos);
        }

        @Override
        public int hashCode() {
            return Objects.hash(serverInfos);
        }
    }
}
