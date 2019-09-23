package Threading._09_LowLevelMultiThreadingTechnique;


import java.util.LinkedList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws InterruptedException {
        final Processor processor=new Processor();

        Thread producer=new Thread(()-> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer=new Thread(()-> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

class Processor{

    private LinkedList<Integer> list=new LinkedList();
    private final int LIMIT=10;
    private Object lock=new Object();

    public void produce() throws InterruptedException {
        int value=0;
        while (true){
            synchronized (lock){
                while(list.size()==LIMIT){
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        Random random=new Random();
        while (true){
            synchronized (lock){
                while(list.isEmpty()){
                    lock.wait();
                }
                System.out.print("List size inside consume: "+list.size());
                int value=list.removeFirst();
                System.out.println("; Value popped from list is: "+value);
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000));
        }
    }
}