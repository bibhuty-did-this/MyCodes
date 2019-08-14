package Threading._03_ThreadSynchronizationByPreventingInterleaving;

public class App {

    private int count=0;
    public static void main(String[] args) throws InterruptedException {
        App app=new App();
        app.doWork();
    }

    public void doWork() throws InterruptedException {
        Thread thread1=new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });
        Thread thread2=new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join(); // waits until the thread dies
        thread2.join(); // waits until the thread dies

        System.out.println("count is "+count);
    }

    public synchronized void increment(){
        ++count;
    }

}