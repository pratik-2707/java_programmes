//KMP ALGORITHM
// Gives Index of the First Occurrence of pattern in a text
public class kmp_string {

    // alternate function using while loop
    // implemented by me
    static int[] pref_func(String s) {
        int i=1;int j=0;
        int n = s.length()   ;

        int[] p = new int[n] ;
        while(i<n) {
            if(s.charAt(i)==s.charAt(j)) {
                j++;
                p[i] = j;
                i++;
            }
            else {
                if(j==0) {
                    p[i] = 0;
                    i++;
                }
                else {
                    j = p[j-1] ;
                }
            }
        }

        return p;
    }

    // static int[] pref_func(String s) {  // O(n)

    //     int n = s.length() , i  ;
    //     int[] p = new int[n] ;

    //     for(i=1;i<n;i++) {
    //         int j = p[i-1] ;
    //         while(j>0 && s.charAt(i)!=s.charAt(j)) {
    //             j = p[j-1] ;
    //         }
    //         if(s.charAt(i)==s.charAt(j)) {
    //             j++;
    //         }
    //         p[i] = j;
    //     }
    //     return p;
    // }

    static int kmp_func(String s,String sub) {
        int n = s.length() , m = sub.length() , i , j , index=-1;
        int[] rs = pref_func(sub) ; // getting lps array
        i=0;
        j=0;
        while(i<n) {
            if(s.charAt(i)==sub.charAt(j)) {
                i++;
                j++;
            }
            else {
                if(j!=0) {
                    j = rs[j-1] ;
                }
                else {
                    i++;
                }
            }

            if(j==m) {
                index = (i-m) ;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "pratik" , sub = "tik";
        System.out.println(kmp_func(s,sub));
    }  
}
