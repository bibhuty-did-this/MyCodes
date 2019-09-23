package Threading._01_WayOfCreatingThreads;

public class App {
    public static void main(String[] args) {

        /**
         * First way of creating threads
         */
        RunnerExtendingThread thread1 =new RunnerExtendingThread();
        // thread1.run(); // Doing this will call the main method of the class
        thread1.start();

        RunnerExtendingThread thread2 =new RunnerExtendingThread();
        thread2.start();

        /**
         * Second way of creating threads
         */
        Thread thread3=new Thread(new RunnerImplementingRunnable());
        Thread thread4=new Thread(new RunnerImplementingRunnable());

        thread3.start();
        thread4.start();


        /**
         * Third way of creating threads
         */
        Thread thread5=new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread5.start();

    }
}

class RunnerExtendingThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnerImplementingRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}