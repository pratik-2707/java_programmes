import java.util.Arrays;

/**
 * lcs
 */
public class lcs {

    static int[][] rs = new int[1005][1005] ;


    static int func(String s , String t,int i ,int j) {
        if(i<0 || j<0) {
            return 0;
        }
        else if(i==0 && j==0) {
            if(s.charAt(i)==t.charAt(j)) {
                return 1;
            }
            else {
                return 0 ;
            }
        }
        else {
            if(rs[i][j]!=-1) {
                return rs[i][j] ;
            }
            else {
                if(s.charAt(i)==t.charAt(j)) {
                    rs[i][j] = func(s,t,i-1,j-1) + 1;
                }
                else {
                    rs[i][j] = Math.max(func(s,t,i-1,j),func(s,t,i,j-1)) ;
                }
                return rs[i][j] ;
            }
        }
    }

    public static void main(String[] args)  {
        String  s = "abccds" ;
        String t = "acs" ;
        for(int[] jj:rs) {
            Arrays.fill(jj,-1) ;
        }
        int n = s.length() , m = t.length() ;
        System.out.println(func(s,t,n-1,m-1));
    }
}