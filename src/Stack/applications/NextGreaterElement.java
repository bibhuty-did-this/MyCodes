package Stack.applications;

import java.util.Stack;

/**
 * Algorithm:
 *  1. Take the first element and put it into the Stack
 *  2. Traverse from the next element
 *      2.1 Put the current element into nextElement
 *      2.2 If the Stack is not empty then pop the top elements
 *          until a top element is greater than the nextElement
 *          and the nextElement is their next greater element
 *      2.3 Push the next greater top element, if present into the Stack
 *  3. Push the nextElement into the Stack
 *  4. Pop the rest element from the Stack and their next greater element is -1
 */
public class NextGreaterElement{

    public static void nextGreaterElement(int[] array){

        //Initialize the Stack
        Stack<Integer> stack=new Stack<>();
        int length=array.length;//store the length in some local variable for efficiency

        //Push the first element into the Stack
        stack.push(array[0]);

        //Start traversing from the next element to the end
        for(int i=1;i<length;++i){
            //take the next element
            int nextElement=array[i];

            //check whether the Stack is empty or not
            if(!stack.isEmpty()){

                //take the top element of the Stack
                int topElement=stack.pop();

                //pop the Stack until you find the top element of the Stack greater than
                //the next element(or the current item of the array)
                while(topElement<nextElement){
                    System.out.println(topElement+" --> "+nextElement);//print the next greater element
                    if(stack.isEmpty())
                        break;//check for if the Stack is empty
                    topElement=stack.pop();//get the other top element of the Stack
                }

                //If you find the top element greater than the nextElement put it into the Stack again
                if(topElement>nextElement)
                    stack.push(topElement);
            }

            //Push the nextElement(or the current item of the array) into the Stack
            stack.push(nextElement);
        }

        //Rest element of the Stack must have the next greater element as -1
        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" --> "+-1);
        }
    }
    public static void main(String[] args){
        int array[]={ 4, 5, 2, 25 };
        System.out.println("The array is");
        for(int element: array)
            System.out.print(element+" ");
        System.out.println("\n\nThe next greater elements of the elements are");
        nextGreaterElement(array);
    }
}
