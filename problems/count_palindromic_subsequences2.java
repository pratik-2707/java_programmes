import java.util.Arrays;

public class count_palindromic_subsequences2 {

    // program will count the number of plaindromic subsequences in a string (not necessarily distinct)
    static long[][] rs = new long[1005][1005] ;
    
    static long mod = 1000000007;

    static long func(int i , int j,String s) {
        if(i==j) {
            return 1;
        }
        else if(i>j){
            return 0;
        }
        else if(rs[i][j]!=-1) {
            return rs[i][j] ;
        }
        else {
            if(s.charAt(i)==s.charAt(j)) {
                rs[i][j] = ((func(i,j-1,s) + func(i+1,j,s))%mod +1)%mod ;
            }
            else {
                rs[i][j] = ((func(i,j-1,s) + func(i+1,j,s))%mod - func(i+1,j-1,s) + mod)%mod ;
                // the reason why there is need to add mod above is that 
                // in case if(func(i,j-1) + func(i+1,j)) exceeds int size then 
                // after taking mod it will be very small and if func(i+1,j-1) is greater
                // than this , then result wull be negative , hence to handle this
                // we add mod such that final answer will be positive
            }
            return rs[i][j]%mod ;
        }
    }

    public static void main(String[] args) {
        String s = "ABBA" ; 
        for(long[] jj:rs) {
            Arrays.fill(jj,(long)-1) ; 
        }
        System.out.println(func(0,s.length()-1,s));
    }
}
