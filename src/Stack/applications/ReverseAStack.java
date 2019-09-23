package Stack.applications;

import java.util.Stack;

/**
 * Algorithm:
 * 1. Pop item one by one and then put them in the buffer
 * 2. Add each of the popped item individually at the end of the Stack
 *
 */
public class ReverseAStack{

    public static Stack<Integer> stack=new Stack<>();

    //Reverses the whole Stack using recursion
    public static void reverse(){

        //Until the Stack is empty recursively call the function
        if(!stack.isEmpty()){

            //Store the data in the buffer
            int item=stack.pop();

            //Repeat so that all the items are popped out and stored in the buffer
            reverse();

            //Add each item at the beginning of the Stack at each step
            insertAtBottom(item);
        }
    }

    public static void insertAtBottom(int item){
        if(stack.isEmpty())stack.push(item);
        else{
            int newItem=stack.pop();
            insertAtBottom(item);
            stack.push(newItem);
        }
    }

    public static void main(String[] args){
        for(int i=0;i<10;++i)stack.push(i);
        System.out.println("The original Stack is\n"+stack);
        reverse();
        System.out.println("The reversed Stack is\n"+stack);
    }
}
