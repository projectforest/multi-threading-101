package demo1;

/**
 * Created by hlin on 2015-12-02.
 */
class Runner extends Thread {
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("sup" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class App {
    public static void main (String[] args){
        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();
    }
}
