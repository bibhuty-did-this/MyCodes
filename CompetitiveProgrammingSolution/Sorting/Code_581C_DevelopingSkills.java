import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author o_panda_o(emailofpanda@yahoo.com)
 */
public class Code_581C_DevelopingSkills{
    public static void main(String[] args){
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
        _581C_ solver=new _581C_();
        solver.solve(1,in,out);
        out.close();
    }
    static class _581C_{
        public void solve(int testNumber,InputReader in,OutputWriter out){
            int n=in.nextInt(), k=in.nextInt();
            ArrayList<Number> numbers=new ArrayList<>();
            for(int i=0;i<n;++i) numbers.add(new Number(in.nextInt()));
            while(k!=0){
                Collections.sort(numbers,Comparator.comparingInt(o->o.number%10));
            /*for(Number skill:numbers)out.print(skill.number,"");
            out.println();*/
                if(k+numbers.get(n-1).number%10<10) break;
                boolean change=false;
                for(int i=n-1;i>=0;--i){
                    if(numbers.get(i).number==100) continue;
                    if(numbers.get(i).number%10+k>=10){
                        change=true;
                        k-=(10-numbers.get(i).number%10);
                        //It'll give an error
                        //numbers.set(i,new Number(numbers.get(i).number+10-numbers.get(i).number%10));
                        numbers.set(i,new Number(numbers.get(i).number+10-numbers.get(i).number%10));
                    }else break;
                }
                if(!change) break;
            }
            int points=0;
            for(Number skill : numbers) points+=skill.number/10;
            out.print(points);
        }
    }
    static class InputReader{
        private InputStream stream;
        private byte[] buf=new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;
        public InputReader(InputStream stream){
            this.stream=stream;
        }
        public int read(){
            if(numChars==-1){
                throw new InputMismatchException();
            }
            if(curChar>=numChars){
                curChar=0;
                try{
                    numChars=stream.read(buf);
                }catch(IOException e){
                    throw new InputMismatchException();
                }
                if(numChars<=0){
                    return -1;
                }
            }
            return buf[curChar++];
        }
        public int nextInt(){
            int c=read();
            while(isSpaceChar(c)){
                c=read();
            }
            int sgn=1;
            if(c=='-'){
                sgn=-1;
                c=read();
            }
            int res=0;
            do{
                if(c<'0' || c>'9'){
                    throw new InputMismatchException();
                }
                res*=10;
                res+=c-'0';
                c=read();
            }while(!isSpaceChar(c));
            return res*sgn;
        }
        public boolean isSpaceChar(int c){
            if(filter!=null){
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }
        public static boolean isWhitespace(int c){
            return c==' ' || c=='\n' || c=='\r' || c=='\t' || c==-1;
        }
        public interface SpaceCharFilter{
            public boolean isSpaceChar(int ch);
        }
    }
    static class Number{
        public int number;
        public Number(int number){
            this.number=number;
        }
    }
    static class OutputWriter{
        private final PrintWriter writer;
        public OutputWriter(OutputStream outputStream){
            writer=new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
        public OutputWriter(Writer writer){
            this.writer=new PrintWriter(writer);
        }
        public void close(){
            writer.close();
        }
        public void print(int i){
            writer.print(i);
        }
    }
}

