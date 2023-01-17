public class binary_exponentiation {
// we can use modulo for greater calculation

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

    public static void main(String[] args) {
        System.out.println(func(2,10));
    }
}
