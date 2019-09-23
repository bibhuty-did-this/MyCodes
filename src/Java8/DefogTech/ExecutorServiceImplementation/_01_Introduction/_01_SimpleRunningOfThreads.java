package Java8.DefogTech.ExecutorServiceImplementation._01_Introduction;

public class _01_SimpleRunningOfThreads {
    public static void main(String[] args) {
        /**
         * This is the way where for each loop one OS thread is created which
         * is an expensive operation in its own. So, better to use a thread pool
         * instead
         */
        for(int i=0;i<10;++i){
            Thread thread=new Thread(new Task());
            thread.start();
        }
        System.out.println("Thread Name: "+Thread.currentThread().getName());
    }
    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread Name Of Task: "+Thread.currentThread().getName());
        }
    }
}
