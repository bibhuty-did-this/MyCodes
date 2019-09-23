package Java8.DefogTech.ExecutorServiceImplementation._02_TypeOfPools;

public class _01_Introduction {
    public static void main(String[] args) {
        System.out.println(
                "Java provides 4 kind of thread pools." +
                        "\n1. FixedThreadPool" +
                        "\n2. CachedThreadPool" +
                        "\n3. ScheduledThreadPool" +
                        "\n4. SingleThreadedExecutor"
        );
        System.out.println(
                "\n-----FixedThreadPool-----" +
                        "\na) It has fixed number of threads." +
                        "\nb) You keep submitting the task which" +
                        "is submitted to a thread safe queue(generally" +
                        "a blocking queue)" +
                        "\nc) All these threads will fetch tasks from the" +
                        "queue and execute one after the another"
        );
        System.out.println(
                "\n-----CachedThreadPool-----" +
                        "\na) It doesn't have a fixed number of threads nor a queue" +
                        "to hold number of tasks you submit" +
                        "\nb) The queue is replaced by synchronous queue which has only " +
                        "space for a single item." +
                        "\nc) Once a task is submitted to the queue it'll search for a existing" +
                        "thread to execute the task and in case no thread is found then\n it'll create" +
                        " a new thread and add it to pool and ask that thread to execute the task." +
                        "\nd) As it has the capacity to create a thread, so it'll destroy the same thread" +
                        "if it finds the thread ideal for more than 60 sec."
        );
        System.out.println(
                "\n-----ScheduledThreadPool-----" +
                        "\na) For specific kind of task we want to schedule after a certain delay" +
                        "\nb) service.schedule, service.scheduleAtFixedRate, service.scheduleAtFixedDelay" +
                        "are important functions." +
                        "\nc) Stored data in a delay queue, tasks are order in execution order."
        );
        System.out.println(
                "\n-----SingleThreadedExecutor-----" +
                        "\na) Only a single thread" +
                        "\nb) It only fetched one task from the blocking queue and executes" +
                        "\nc) In case an exception occurs and the thead is killed then it'll recreate the same" +
                        "\nd) It is essential when we want to ensure that one task to be done after another."
        );
    }
}
