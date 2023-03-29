public class Minimum_characters_to_be_added_at_front_to_make_string_palindrome {

    static int solve(String s) {  // this will return the count required
        int i , j=0 , n= s.length() ;
        int[] rs = new int[2*n+1] ;
        StringBuilder sbr = new StringBuilder(s);
        // To reverse the string
        String rev = sbr.reverse().toString();
        String temp  = s  + '#' + rev ;
        int tn = temp.length() ;
        i=1;
        while(i<tn) {
            if(temp.charAt(i)==temp.charAt(j)) {
                rs[i] = j+1;
                j++;
                i++;
            }
            else {
                if(j==0) {
                    rs[i] = 0;
                    i++;
                }
                else {
                    j = rs[j-1] ;
                }
            }
        }
        return n- rs[tn-1]  ;
    }

    static String shortestPalindrome(String s) { // this will return the newly formed palindromic string
        int i , j=0 , n= s.length() ;
        int[] rs = new int[2*n+1] ;
        StringBuilder sbr = new StringBuilder(s);
        // To reverse the string
        String rev = sbr.reverse().toString();
        String temp  = s  + '#' + rev ;
        int tn = temp.length() ;
        i=1;
        while(i<tn) {
            if(temp.charAt(i)==temp.charAt(j)) {
                rs[i] = j+1;
                j++;
                i++;
            }
            else {
                if(j==0) {
                    rs[i] = 0;
                    i++;
                }
                else {
                    j = rs[j-1] ;
                }
            }
        }
        return  rev.substring(0, n - rs[tn - 1]) + s  ;
    }

    public static void main(String[] args) {
        String s = "AABBAAXY" ;
        System.out.println(solve(s));
        System.out.println(shortestPalindrome(s));
    }
}
