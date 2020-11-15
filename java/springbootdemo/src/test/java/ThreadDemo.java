public class ThreadDemo {


    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Hello World1"+ Thread.currentThread());
        }).start();
        new Thread(() -> {
            System.out.println("Hello World2"+ Thread.currentThread());
        }).start();
        System.out.println("Hello World0"+ Thread.currentThread());
    }
}
