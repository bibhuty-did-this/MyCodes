package Stack.applications;

/**
 * Algorithm:
 *
 */
public class TwoStacksInAnArray{
    public static void main(String[] args){
        TwoStacks twoStacks=new TwoStacks();
        twoStacks.peek1();
        twoStacks.peek2();
        twoStacks.pop1();
        twoStacks.pop2();
        twoStacks.push1(1);
        twoStacks.push2(1_00_000);
        System.out.println(twoStacks.peek1());
        System.out.println(twoStacks.peek2());
        System.out.println(twoStacks.pop1());
        System.out.println(twoStacks.pop2());
    }
}

class TwoStacks{
    
    //Capacity of the Stack
    private static final int CAPACITY=1_00_000;
    
    //Necessary Stack variables
    private int top1;
    private int top2;
    private int stack[];
    
    public TwoStacks(){
        top1=-1;
        top2=CAPACITY;
        stack=new int[CAPACITY];
    }
    
    public void push1(int item){
        if(isFull1())
            System.out.println("Stack Overflow");
        else
            stack[++top1]=item;
    }
    
    public void push2(int item){
        if(isFull2())
            System.out.println("Stack overflow");
        else
            stack[--top2]=item;
    }
    
    public int pop1(){
        if(isEmpty1())
            System.out.println("The Stack is empty");
        else
            return stack[top1--];
        return Integer.MIN_VALUE;
    }

    public int pop2(){
        if(isEmpty2())
            System.out.println("The Stack is empty");
        else
            return stack[top2++];
        return Integer.MIN_VALUE;
    }

    public int peek1(){
        if(isEmpty1())
            System.out.println("The Stack is empty");
        else
            return stack[top1];
        return Integer.MIN_VALUE;
    }

    public int peek2(){
        if(isEmpty2())
            System.out.println("The Stack is empty");
        else
            return stack[top2];
        return Integer.MIN_VALUE;
    }

    public boolean isEmpty1(){
        return top1==-1;
    }

    public boolean isEmpty2(){
        return top2==CAPACITY;
    }

    public boolean isFull1(){
        return top1+1==top2?true:false;
    }
    
    public boolean isFull2(){
        return top1+1==top2?true:false;
    }
}