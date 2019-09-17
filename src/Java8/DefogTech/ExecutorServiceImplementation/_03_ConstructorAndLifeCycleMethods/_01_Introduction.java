package Java8.DefogTech.ExecutorServiceImplementation._03_ConstructorAndLifeCycleMethods;

public class _01_Introduction {
    public static void main(String[] args) {
        System.out.println("\nActual method behind the scenes of ThreadPoolExecutor is: \n");
        System.out.println(
                "public ThreadPoolExecutor(int corePoolSize,\n" +
                        "        int maximumPoolSize,\n" +
                        "        long keepAliveTime,\n" +
                        "        TimeUnit unit,\n" +
                        "        BlockingQueue<Runnable> workQueue,\n" +
                        "        ThreadFactory threadFactory,\n" +
                        "        RejectedExecutionHandler handler)"
        );

        System.out.println("\nDetails about pool size of threads: \n" +
                "- CurrentSize = Core Pool Size(initial size) " +
                "+\n              Current Pool Size(Threads added/deleted based on pool type and" +
                " keep alive time)\n" +
                "- They all are inside `Max Pool Size` ");
        System.out.println(
                "\nNOTE: Core pool threads are never killed unless " +
                        "allowCoreThreadTimeOut(boolean value) is set to true."
        );
    }
}
