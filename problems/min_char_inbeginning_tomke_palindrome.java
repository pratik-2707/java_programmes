
public class min_char_inbeginning_tomke_palindrome {
    
    
    static int[] pref_func(String s) {  // O(n) lps function

        int n = s.length() , i  ;
        int[] p = new int[n] ;

        for(i=1;i<n;i++) {
            int j = p[i-1] ;
            while(j>0 && s.charAt(i)!=s.charAt(j)) {
                j = p[j-1] ;
            }
            if(s.charAt(i)==s.charAt(j)) {
                j++;
            }
            p[i] = j;
        }
        return p;
    }
    
    static int solve(String a) {
        StringBuilder sb = new StringBuilder() ;
        sb.append(a) ;
        sb.append("*") ;
        StringBuilder rv = new StringBuilder();
        rv.append(a) ;
        rv.reverse() ;
        sb.append(rv.toString()) ;
        int[] rs = pref_func(sb.toString()) ;
        return a.length()-rs[rs.length-1] ;     
    }

    public static void main(String[] args) {
        String a= "aaaaaa" ;
        System.out.println(solve(a));
    }
}
