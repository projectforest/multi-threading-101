package demo3_1;

/**
 * Created by hlin on 2015-12-08.
 */
public class App {


    public static void main(String[] args){
        App app = new App();
        app.doWork();
    }

    public synchronized void increment(){
        count++;
    }

    public void doWork(){
        Thread t1 = new Thread(new Runnable(){
           public void run(){
               for (int i = 0; i < 1000; i++){
                   increment();
               }
           }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for (int i = 0; i < 1000; i++){
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }

    private int count = 0;
}
