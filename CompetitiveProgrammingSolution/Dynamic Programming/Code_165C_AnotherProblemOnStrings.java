import java.util.Scanner;

public class Code_165C_AnotherProblemOnStrings {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int k=in.nextInt();
        String s=in.next();
        int n=s.length();
        int[] sum=new int[n+1];
        int[] sumCount=new int[n+1];
        long ans=0;
        sumCount[0]=1; // as there is one occurence when there is no zeroes present(base case)
        for(int i=1;i<=n;++i){
            sum[i]=s.charAt(i-1)-'0'+sum[i-1];
            if(sum[i]>=k)
                ans+=sumCount[sum[i]-k];
            sumCount[sum[i]]++;
        }
        System.out.println(ans);
    }
}
