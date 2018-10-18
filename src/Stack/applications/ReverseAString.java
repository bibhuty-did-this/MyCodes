package Stack.applications;

import java.util.Stack;

public class ReverseAString{

    public static void reverse(StringBuffer string){
        int n=string.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;++i)
            stack.push(string.charAt(i));
        for(int i=0;i<n;++i)
            string.setCharAt(i,stack.pop());
    }
    public static void main(String[] args){
        StringBuffer string=new StringBuffer("Bibhuti");
        System.out.println("The original string is "+string.toString());
        reverse(string);
        System.out.println("The reversed string is "+string.toString());
    }
}
