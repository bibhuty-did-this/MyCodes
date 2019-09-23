package Stack.applications;

import java.util.Stack;

/**
 * Algorithm for finding postfix expression:
 *  1. Scan the expression from left to right
 *  2. If you find a operand then push it to the result expression
 *  3. Else if the scanned stuff is an operator then
 *      3.1 If its precedence is greater than the previous operator of the operator
 *          Stack or the Stack is simply empty, then simply push it into the operator
 *          Stack
 *      3.2 If its precedence is less than the previous operator of the operator
 *          Stack then pop the scanned operator from the Stack until you get an
 *          operator having higher precedence than the scanned operator or the
 *          operator Stack is empty. Add the popped operators simultaneously to the
 *          resultant expression
 * 4. If the scanned operator is '(' then simply push it into the Stack
 * 5. If the scanned operator ir ')' then pop all the element from the Stack and add it
 *    to the expression until you encounter '('.
 * 6. Repeat the step 2-6 until the entire expression is scanned
 * 7. Pop the operator Stack until it is not empty
 *
 */
public class InfixToPostfix{

    /**
     * This function takes care of precedence of various operators.
     * It returns the higher value for the higher precedence of the operator.
     */
    public static int precedence(char operator){
        switch(operator){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    /**
     * This function returns infix to postfix expression using the above
     * mentioned algorithm and returns the resultant string.
     */
    public static String infixToPostfix(String expression){

        StringBuilder result=new StringBuilder();//initialize the result
        int length=expression.length();//store the result into length for efficiency
        Stack<Character> operatorStack=new Stack<>();

        //Scan the operator from left to right
        for(int i=0;i<length;++i){

            //Check if it is an operand
            if(Character.isLetterOrDigit(expression.charAt(i))){
                result.append(expression.charAt(i));
            }

            //Check if it is an '('
            else if(expression.charAt(i)=='('){
                operatorStack.push(expression.charAt(i));
            }

            //Check for ')' and if found put the popped result in the
            //expression until you encounter ')'
            else if(expression.charAt(i)==')'){
                while(!operatorStack.isEmpty() && operatorStack.peek()!='(')
                    result.append(operatorStack.pop());

                if(!operatorStack.isEmpty() && operatorStack.peek()!='(')
                    return "Invalid Expression";
                else operatorStack.pop();
            }

            //Check for an operator and if found then add the popped result to the
            //Stack until you encounter an operator having more precedence than the
            //scanned operator in the operator Stack or it is empty
            else{
                while(!operatorStack.isEmpty() && precedence(expression.charAt(i))<=precedence(operatorStack.peek()))
                    result.append(operatorStack.pop());

                operatorStack.push(expression.charAt(i));
            }

        }

        //pop all the elements from the operator Stack
        while(!operatorStack.isEmpty())
            result.append(operatorStack.pop());

        return result.toString();
    }
    public static void main(String[] args){
        //String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String exp = "A*(B+C)/D";
        System.out.println(infixToPostfix(exp));
    }
}
