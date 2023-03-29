import java.util.Arrays;

public class minimum_insertions_to_make_string_palindrome {

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

    public static void main(String[] args) {
        String s = "abcbabccbc" ;
        int n = s.length();
        for(int[] jj:rs) {
            Arrays.fill(jj,-1);
        }
        StringBuilder sb= new StringBuilder() ;
        sb.append(s) ;
        sb.reverse() ;
        System.out.println(n- func(s,sb.toString(),n-1,n-1));
    }
}
