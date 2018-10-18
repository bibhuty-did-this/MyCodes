package Stack.applications;

import java.util.Stack;

/**
 * Algorithm:
 * Traverse the expression from left to right
 *  1. If the character is found to be a opening bracket then push it into the Stack
 *  2. If it is a closing bracket then look for its corresponding opening bracket at
 *     the top of the Stack. If found then proceed or return false from the expression.
 */
public class BalancedParenthesisExpression{
    public static boolean checkBalancedParenthesisExpression(String expression){
        Stack<Character> parentehsis=new Stack<>();
        int length=expression.length();

        for(int i=0;i<length;++i){
            if(expression.charAt(i)=='(' || expression.charAt(i)=='[' || expression.charAt(i)=='{')
                parentehsis.push(expression.charAt(i));
            else if(expression.charAt(i)==')' || expression.charAt(i)==']' || expression.charAt(i)=='}'){
                if(parentehsis.empty())
                    return false;
                else if(!isMathchingParenthesis(parentehsis.pop(),expression.charAt(i)))
                    return false;
            }
        }
        return parentehsis.empty()?true:false;
    }

    public static boolean isMathchingParenthesis(char bracket1,char bracket2){
        if(bracket1=='(' &&  bracket2==')')return true;
        else if(bracket1=='[' && bracket2==']')return true;
        else if(bracket1=='{' && bracket2=='}')return true;
        return false;
    }
    public static void main(String[] args){
        String expression="[()]{}{[()()]()}";
        if(checkBalancedParenthesisExpression(expression))
            System.out.println("The expression is balanced");
        else
            System.out.println("The expression is unbalanced");
    }
}
