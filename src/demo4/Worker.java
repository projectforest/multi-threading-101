package demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
/**
 * Created by hlin on 2015-12-08.
 */
public class Worker {
    public void main(){
        System.out.println("starting..");

        long start = System.currentTimeMillis();

        //process();

        Thread t1 = new Thread(new Runnable(){
            public void run(){
                process();
            }
        });



        Thread t2 = new Thread(new Runnable(){
            public void run(){
                process();
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
        long end = System.currentTimeMillis();

        System.out.println("Time take: " + (end - start));
        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());
    }

    public void stageOne(){
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random_num.nextInt(100));
        }



    }

    public void stageTwo(){
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random_num.nextInt(100));
        }
        
    }

    public void process(){
        for(int i=0; i<1000; i++){
            stageOne();
            stageTwo();
        }
    }
    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();//exception occur share data from multiple threads
    //only one lock for worker
    private Random random_num = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();
}
