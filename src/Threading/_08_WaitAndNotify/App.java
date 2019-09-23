package Threading._08_WaitAndNotify;

import java.util.Scanner;

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
    public void produce() throws InterruptedException {
        synchronized(this){ // Intrinsic lock of processor object
            System.out.println("Producer thread running...");
            /*
            * Resource intrinsic method.(Gives up control over the lock)
            *
            * Doesn't consume resource(say as consumed by infinitely running while loop)
            *
            * Can only be used inside synchronized code block
            * */
            wait();
            // The thread is resumed when it regains the control of the lock
            // or some other thread which has this lock notifies.
            System.out.println("Producer thread resumed...");
        }
    }

    public void consume() throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this){
            System.out.println("Waiting for return key...");
            scanner.nextLine();
            System.out.println("Return key pressed.");

            /*
            * Can only be called inside synchronized code block
            *
            * Will notify one of the thread to acquire the lock.
            *
            * It doesn't handover the control of the lock unlike wait. Unless
            * and until the block is done with the lock, it's not going to
            * relinquish the lock.
            * */
            notify();
            Thread.sleep(5000);
        }
    }
}
