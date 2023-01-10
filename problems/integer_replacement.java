/**
 * integer_replacement
 */
public class integer_replacement {

    static int func(int n) {
        if(n==1) {
            return 0;
        }
        else if(n==Integer.MAX_VALUE) {
            return func(1073741824) + 2;
        }
        else {
            if(n%2==0) {
                return func(n/2) + 1;
            }
            else {
                if(n%4==1 || n==3) {
                    return func(n-1) + 1;
                }
                else {
                    return func(n+1) + 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(func(100)) ;
    }
}