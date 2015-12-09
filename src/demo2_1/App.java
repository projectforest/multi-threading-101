
package demo2_1;
import java.util.Scanner;
class Processor extends Thread {

    private volatile boolean running = true;

    public void run(){
        while(running){
            System.out.println("sup");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running = false;

    }
}
/**
 * Created by hlin on 2015-12-04.
 */
public class App {

    public static void main(String[] args){

        Processor proc1 = new Processor();

        proc1.start();

        System.out.println("press return to terminate");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();
    }
}
