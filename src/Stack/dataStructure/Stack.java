package Stack.dataStructure;

/**
 * Stack:
 *  - This data structure follow LIFO/FILO principle
 *  - The basic operation of Stack are as follows:
 *      1. Push: Adding an item to the Stack
 *      2. Pop: Removing an item from the top of the Stack
 *      3. Peek: Retrieving the top item of the Stack
 *      4. isEmpty: To check if the Stack is empty or not
 *  - The best part of these operations are they all have O(1) time complexity
 *  - Application of Stack:
 *      1. Redo-Undo features like Photoshop, Editors etc.
 *      2. Forward and backward feature in web browser
 *      3. Storing the temporary variables
 *  - Stack can be implemented by using:
 *      1. Arrays
 *      2. LinkedList
 */
public class Stack{

    private static final int MAX=1000;
    private int top;
    private int stack[];

    public Stack(){
        top=-1;
        stack=new int[MAX];
    }

    /**
     * Adds item to the top of the Stack if the Stack is not full.
     * Time complexity of the operation: O(1)
     */
    public void push(int item){
        if(top>=MAX){
            System.out.println("dataStructure.Stack overflow");
            return;
        }
        stack[++top]=item;
        System.out.println(item+" is pushed to the Stack");
    }

    /**
     * Removes the top item of the Stack and returns it to the user
     * Time complexity of the operation: O(1)
     */
    public int pop(){
        if(!isEmpty())return stack[top--];
        else {
            System.out.println("The Stack is empty");
            return Integer.MIN_VALUE;
        }
    }

    /**
     * Gets the top item of the Stack and returns it to the user
     * Time complexity of the operation: O(1)
     */
    public int peek(){
        if(!isEmpty())return stack[top];
        else{
            System.out.println("There is no element in the Stack");
            return Integer.MIN_VALUE;
        }
    }

    /**
     * This is a helper function to check if the Stack is empty or not
     */
    public boolean isEmpty(){
        return top<0?true:false;
    }

    public static void main(String[] args){
        Stack stack=new Stack();
        int top=stack.peek();
        top=stack.pop();
        stack.push(1);
        stack.push(2);
        System.out.println("The top item is "+stack.pop());
        System.out.println("The top item is "+stack.peek());
    }
}
