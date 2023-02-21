public class binary_exponentiation {
// we can use modulo for greater calculation

    static long mod = (long)1e9+7 ;

    static int func(int a , int b) {
        int ans = 1;
        while(b>0) {
            if((b&1)!=0) {
                ans *= a;
            }
            a = a*a ;
            b>>=1;
        }
        return ans ;
    }

    static long func2(long a, long b) {
        if(b==0) {
            return 1;
        }
        else {
            long temp = func2(a,b/2) ;
            temp *= (temp%mod) ;
            temp %= mod;
            if(b%2==1) {
                a %= mod;
                temp = (temp*a)%mod ;
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(func(2,10));
        System.out.println(func2(2,500000003));
    }
}
