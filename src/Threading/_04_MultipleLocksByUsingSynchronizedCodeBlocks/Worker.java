package Threading._04_MultipleLocksByUsingSynchronizedCodeBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

    private Random random=new Random();

    /**
     * Synchronized methods take one global lock by slowing multiple
     * processes which are even independent, so synchronized blocks are
     * recommended in such cases.
     */
    public Object lock1=new Object();
    public Object lock2=new Object();

    /**
     * We can use locks on list1 and list2 but it is good practice to
     * create lock objects, because we never know if the after locking
     * this object and doing operations on it we don't know if java has
     * optimized the variables to point on the same state or different one.
     *
     * Bottomline is you can complicate things while using lock on actual
     * objects you are working on.
     */
    private List<Integer> list1=new ArrayList<>();
    private List<Integer> list2=new ArrayList<>();

    public void stageOne() throws InterruptedException {
        synchronized (lock1){
            Thread.sleep(1);
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() throws InterruptedException {
        synchronized (lock2){
            Thread.sleep(1);
            list2.add(random.nextInt(100));
        }
    }

    public void process() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() throws InterruptedException {
        System.out.println("Starting...");

        long start=System.currentTimeMillis();

        Thread thread1=new Thread(() -> {
            try {
                process();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2=new Thread(() -> {
            try {
                process();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        long end=System.currentTimeMillis();

        System.out.println("Time taken "+(end-start));
        System.out.println("List 1's size is - "+list1.size());
        System.out.println("List 2's size is - "+list2.size());

    }
}

