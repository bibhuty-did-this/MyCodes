package Stack.applications;

import java.util.Stack;

/**
 * Algorithm:
 *  1. First pop each and every element of the Stack and put them in some
 *     variable and hold them
 *  2. Insert each and every item individually in a sorted manner inside
 *     the Stack
 */
public class SortingAStack{

    //Initialization of the Stack
    public static Stack<Integer> stack=new Stack<>();

    //Method to sort the Stack
    public static void sortStack(){

        //Recurse the method unless the Stack is not empty
        if(!stack.isEmpty()){

            //Put every item in the recursion Stack
            int item=stack.pop();

            //This function is useful for keeping each and every variable of the Stack in item
            sortStack();

            //This function puts the 'item' in its proper place in the Stack
            sortedInsert(item);
        }
    }

    //It is to be noted that we are inserting our item in a sorted Stack always if we are using
    //this function
    public static void sortedInsert(int item){

        //Find if the element is the largest element in the Stack
        //If it is largest element or the Stack is empty just push
        //the item into the Stack
        if(stack.isEmpty() || stack.peek()<item)stack.push(item);

        //In case the item is not the largest one then hold the item
        //of the Stack in a temporary variable until you find the perfect
        //for the item to insert
        else{

            //Item of the Stack is kept in hold to insert the 'item' in
            //its desired place
            int newItem=stack.pop();

            //Find a perfect place for 'item' to insert
            sortedInsert(item);

            //After we insert 'item' at its perfect position now it is time
            //to insert the held item into the Stack
            stack.push(newItem);
        }
    }

    public static void main(String[] args){
        int array[]={10,9,5,6,7,8,4,1,2,3};
        for(int item:array)
            stack.push(item);
        System.out.println("The original Stack is\n"+stack);
        sortStack();
        System.out.println("The sorted Stack is\n"+stack);

    }
}
