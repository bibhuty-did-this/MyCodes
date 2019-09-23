package Threading._02_ThreadSynchronizationByPreventingCaching;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Processor processor1=new Processor();
        processor1.start();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Press return to stop");
        scanner.nextLine();
        processor1.shutdown();
    }
}

class Processor extends Thread{

    // It helps to prevent thread caching(occurs when 2 threads are working on same data)
    // run() method runs in its own thread and caches the value of running
    // same goes with method shutdown()
    // volatile keyword makes both of them read both the methods from db
    private volatile boolean running=true; // It ensured that all threads can see the current state of the variable

    @Override
    public void run() {
        while (running){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running=false;
    }
}