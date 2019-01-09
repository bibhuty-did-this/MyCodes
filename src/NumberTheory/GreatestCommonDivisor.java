package NumberTheory;

public class GreatestCommonDivisor {

    /**
     *
     * @param a first number
     * @param b second number
     * @return GCD of the given two numbers with time complexity O(log(max(a,b))) using <b>Euclid's Algorithm</b>
     */
    public int gcd(int a,int b){
        return b==0 ? a : gcd(b,a%b);
    }

    /**
     *
     * @param A first number
     * @param B second number
     * @param data data structure containing data of the coefficients and gcd
     */
    public void extendedEuclidean(int A,int B, Data data){
        if(B==0){
            data.x=1;
            data.y=0;
            data.gcd=A;
        }else{
            extendedEuclidean(B,A%B, data);
            int temp=data.x;
            data.x=data.y;
            data.y=temp-(A/B)*data.y;
        }
    }

    public static void main(String[] args) {
        GreatestCommonDivisor gcd=new GreatestCommonDivisor();
        Data data=new Data();
        int a=16,b=10;
        gcd.extendedEuclidean(a,b,data);
        if(data.gcd==gcd.gcd(a,b)){
            System.out.println("The values of `a` and `b` respectively are "+a+" & "+b);
            System.out.println("The GCD is "+data.gcd);
            System.out.println("The coefficient `x` and `y` of `ax + by` respectively are "+data.x+" & "+data.y);
        }
    }
}
class Data{
    int x,y,gcd;
}
