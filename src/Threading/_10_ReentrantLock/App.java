package Threading._10_ReentrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) throws InterruptedException {

        final Runner runner=new Runner();
        Thread firstThread=new Thread(()-> {
            try {
                runner.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread secondThread=new Thread(()-> {
            try {
                runner.secondThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        runner.finished();
    }
}
class Runner{

    private int count=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    private void increment(){
        for(int i=0;i<10000;++i)++count;
    }

    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("Waiting....");
        condition.await();
        System.out.println("Woken up...");
        try {
            increment();
        }catch (Exception ex){
            System.out.println(ex);
        }finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();

        System.out.println("Press the return key...");
        new Scanner(System.in).nextLine();
        System.out.println("Got the return key...");

        condition.signal(); // only signals doesn't release the lock

        try {
            increment();
        }catch (Exception ex){
            System.out.println(ex);
        }finally {
            // it is necessary with signal
            // entire point being to acquire a lock by another thread
            // it needs to be released first
            lock.unlock();
        }
    }

    public void finished(){
        System.out.println("Final value of count is "+count);
    }
}