package NumberTheory;

public class ModularExponentiation {
    /**
     *
     * @param x  exponent
     * @param n  power
     * @return binary exponentiation of number with time and space complexity O(log n)
     */
    public int binary_exponentiation(int x,int n){
        if(n==0)
            return 1;
        else if(n%2==0)
            return binary_exponentiation(x*x,n/2);
        else
            return x*binary_exponentiation(x*x,(n-1)/2);
    }

    /**
     *
     * @param x exponent
     * @param n power
     * @return binary exponentiation with time complexity O(log n) and space complexity O(1)
     */
    public int binaryExponentiation(int x,int n){
        int result=1;
        while (n>0){
            if(n%2==1)
                result*=x;
            x*=x;
            n/=2;
        }
        return result;
    }

    /**
     *
     * @param x exponent
     * @param n power
     * @param MOD modular
     * @return Modular exponentiation of a number with space and time complexity of O(log n)
     */
    public int modular_exponentiation(int x,int n,int MOD){
        if(n==0)
            return 1;
        else if(n%2==0)
            return modular_exponentiation(((x%MOD)*(x%MOD))%MOD,n/2,MOD);
        else
            return ((x%MOD)*(modular_exponentiation(((x%MOD)*(x%MOD))%MOD,(n-1)/2,MOD)%MOD))%MOD;
    }

    /**
     *
     * @param x exponent
     * @param n power
     * @param MOD modular
     * @return Modular exponentiation of a number with constant space complexty and logarithmic time complexity
     */
    public int modularExponentiation(int n,int x,int MOD){
        int result=1;
        while (n>0){
            if(n%2==1)
                result=((x%MOD)*result)%MOD;
            x=((x%MOD)*(x%MOD));
            n=n/2;
        }
        return result;
    }
}
