package NumberTheory;

public class ModularArithmetic {

    // Addition
    public int add(int a,int b,int mod){
        return ((a%mod)+(b%mod))%mod;
    }

    // Multiplication
    public int multiply(int a,int b,int mod){
        return ((a%mod)*(b%mod))%mod;
    }

    // Subtraction
    public int subtract(int a, int b, int mod){
        return ((a%mod)-(b%mod)+mod)%mod;
    }

    // Division
    public int divide(int a,int b,int mod){
        b=modularMultiplicativeInverse(b,mod);
        return multiply(a,b,mod);
    }

    // Modular Multiplicative Inverse

    /**
     *
     * @param A number
     * @param M modulo
     * @return Modular multiplicative inverse of A if it exists or -1.
     * <b>It is to be noted that modular multiplicative inverse exists if and only if A and M are coprime.
     *    i.e. gcd(A,M)=1</b>
     */
    public int modularMultiplicativeInverse(int A,int M){
        if(gcd(A,M)!=1)
            return -1;
        extendedEuclidean(A,M);
        return (x+M)%M; // In case x is negative it takes care of it
    }


    /*
     * SUPPORTING FUNCTIONS(borrowed from `GreatestCommonDivisor.java`)
     */

    public int gcd(int a,int b){
        return b==0 ? a : gcd(b,a%b);
    }

    int x;
    int y;
    int gcd;
    public void extendedEuclidean(int A,int B){
        if(B==0){
            x=1;
            y=0;
            gcd=A;
        }else{
            extendedEuclidean(B,A%B);
            int temp=x;
            x=y;
            y=temp-(A/B)*y;
        }
    }

    public static void main(String[] args) {
        ModularArithmetic modularArithmetic=new ModularArithmetic();

    }

}
