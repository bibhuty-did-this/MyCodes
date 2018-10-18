package Stack.applications;

import java.util.Arrays;
import java.util.Stack;

/**
 * Algorithm:
 *  1. Traverse each and element of an array
 *  2. While traversing keep each and element in a Stack.
 *  3. At each step of traversing try to find that element from the
 *     Stack which is greater than the current element or simply pop
 *     out the Stack empty. If you find such an element then you'll
 *     get your span or else it'll simply be your index+1
 */

public class StockSpanProblem{

    public static void calculateStockSpan(int price[],int S[]){
        //Initialize the Stack to operate for the 'Stock-span Problem'
        Stack<Integer> stack=new Stack<>();

        //Push the first element to the Stack as it could be one of
        //the item which other element could span to
        stack.push(0);

        //The first element always has span 1 as it doesn't have any
        //element at the left of it
        S[0]=1;

        int n=price.length;//for efficiency and simplicity

        //Loop until all the items are traversed
        for(int i=1;i<n;++i){

            //Unless and until you find an item which is greater than the
            //current price pop out of the Stack
            while(!stack.isEmpty() && price[stack.peek()]<=price[i])
                stack.pop();

            //If you find any item worth it then the span will be the length
            //between them otherwise it'll be one larger than the index as we
            //are calculating the index from 0
            S[i]=(stack.isEmpty()?i+1:i-stack.peek());

            //Push the current element(or index) to the Stack as we don't know
            //whether it is capable of spanning or not. It'll be later checked
            //at the next iteration
            stack.push(i);
        }
    }
    public static void main(String[] args){
        int price[] = {10, 4, 5, 90, 120, 80};
        int n = price.length;
        int S[]=new int[n];
        calculateStockSpan(price,S);
        System.out.println(Arrays.toString(S));
    }
}
