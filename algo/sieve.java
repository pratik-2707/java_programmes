import java.util.Arrays;

public class sieve {

    static boolean[] func(int n) {
        boolean[] isprime = new boolean[n+5] ;
        int  i,j;
        Arrays.fill(isprime,true) ;

        isprime[0] = isprime[1] = false;

        for(i=2;i<n+5;i++) {
            if(isprime[i]) {
                for(j=2;(j*i)<n+5;j++) {
                    isprime[j*i] = false;
                }
            }
        }
        return isprime;
    }

    public static void main(String[] args) {
        int i,j,n=100;
        boolean[] isprime = func(n) ;
        for(i=0;i<n;i++) {
            System.out.println(i+" "+isprime[i]);
        }

    }
}
