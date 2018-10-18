package Stack.applications;

import java.util.Stack;

/**
 * Algorithm for Evaluation Of Postfix:
 * Scan the expression from left to right
 *  1. If the element is a number then push it into the Stack
 *  2. If the element is an operator then evaluate it for the
 *     first 2 elements of the Stack and push it again into it
 * Last element in the Stack is the result
 */
public class EvaluationOfPostfix{

    public static int evaluatePostfix(String expression){
        Stack<Integer> stack=new Stack<>();
        int length=expression.length();
        for(int i=0;i<length;++i){
            //If the element is a number then put it into the Stack
            if(Character.isDigit(expression.charAt(i)))stack.push(expression.charAt(i)-'0');
            //If the element is an operator then evaluate the expression
            //and put the result into the Stack
            else{
                int num2=stack.pop();
                int num1=stack.pop();

                switch(expression.charAt(i)){
                    case '+':
                        stack.push(num1+num2);
                        break;
                    case '-':
                        stack.push(num1-num2);
                        break;
                    case '*':
                        stack.push(num1*num2);
                        break;
                    case '/':
                        stack.push(num1/num2);
                        break;
                    case '^':
                        stack.push((int)Math.pow(num1,num2));
                        break;
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        String expression="231*+9-";
        System.out.println(evaluatePostfix(expression));
    }
}
