package Stack.applications;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Algorithm:
 *
 * In order to implement Stack using Queues we need to implement 2
 * different queues. For implementing them we can go for one of the
 * two operations as follows:
 *          1. Costly push operation and popping in O(1) time
 *          2. Pushing in O(1) time and making the pop operation costly
 *
 */
public class StacksUsingQueue{

    /**
     * 1. Add all the element from the original queue to the support queue
     * 2. Push the required element to the queue
     * 3. Push all the elements from the support queue to the original queue
     *
     *
     * ~ Pop(or dequeue) operation will be like usual
     */
    public static void pushCostlyOperation(){
        Queue<Integer> queue=new LinkedList<>();
        Queue<Integer> supportQueue=new LinkedList<>();
        Queue<Integer> testQueue=new LinkedList<>();
        for(int i=0;i<10;++i){
            while(!queue.isEmpty())
                supportQueue.add(queue.poll());

            queue.add(i*i);
            testQueue.add(i*i);
            while(!supportQueue.isEmpty())
                queue.add(supportQueue.poll());

            System.out.println(queue);
            System.out.println(testQueue);
            System.out.println();
        }
    }


    /**
     * ~ Make the usual push(or enqueue) operation
     *
     * 1. Add all the elements from the original queue to the support queue
     * 2. Deque an element from the support queue and then push every element
     *    to the original queue.
     */
    public static void popCostlyOperation(){
        Queue<Integer> queue=new LinkedList<>();
        Queue<Integer> supportQueue=new LinkedList<>();
        for(int i=0;i<10;++i){
            while(!queue.isEmpty())
                supportQueue.add(queue.poll());

            queue.add(i*i);
            while(!supportQueue.isEmpty())
                queue.add(supportQueue.poll());

            System.out.println(queue);
            System.out.println();
        }


        System.out.println("The pop operation");
        while(!queue.isEmpty()){
            System.out.println(queue);
            while(!queue.isEmpty())supportQueue.add(queue.poll());
            System.out.println(supportQueue.poll());
            while(!supportQueue.isEmpty())queue.add(supportQueue.poll());
        }

    }

    public static void main(String[] args){
        popCostlyOperation();
    }
}
