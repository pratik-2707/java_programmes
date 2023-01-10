import java.util.PriorityQueue;

class Solution {


    static int[] rs = new int[5000] ;

    static  int integerReplacement(int n) {
        if(n==1) {
            return 0 ;
        }
        if(rs[n]!=0) {
            return rs[n] ;
        }
        if(n%2==0) {
            return rs[n]  = integerReplacement(n/2) + 1;
        }
        else {
            return rs[n] = Math.min(integerReplacement(n-1),integerReplacement(n+1)) + 1  ;
        }
    }

    public static void main(String[] args)  {

        int i , j ;

        for(i=1;i<=400;i++) {
            System.out.println(i+  "  =>" + integerReplacement(i)   ) ;
        }
    }
}


