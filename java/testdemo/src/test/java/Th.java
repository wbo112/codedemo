import java.util.Random;

public class Th {
    public static void main(String[] args) {
        Runnable runnable0=()->{
            int sum=0;
            while(true){
                int random=new Random().nextInt();
                sum+=random;
            }
        };
        Runnable runnable1=()->{
            int sum=0;
            while(true){
                int random=new Random().nextInt();
                sum+=random;
            }
        };
        Runnable runnable2=()->{
            int sum=0;
            while(true){
                int random=new Random().nextInt();
                sum+=random;
            }
        };
        Runnable runnable3=()->{
            int sum=0;
            while(true){
                int random=new Random().nextInt();
                sum+=random;
            }
        };
        Runnable runnable4=()->{
            int sum=0;
            while(true){
                int random=new Random().nextInt();
                sum+=random;
            }
        };
        Runnable runnable5=()->{
            int sum=0;
            while(true){
                int random=new Random().nextInt();
                sum+=random;
            }
        };
        new Thread(runnable0).start();
        new Thread(runnable1).start();
        new Thread(runnable2).start();
        new Thread(runnable3).start();
        new Thread(runnable4).start();
        new Thread(runnable5).start();
    }

}
