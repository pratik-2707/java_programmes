/**
 * subsequnces_with_sum_less_than_k
 */
public class subsequnces_with_sum_less_than_k {

    static int[] a = {1,2,5,7,3,8,9} ;
    static int k = 7;
    static int N = a.length ;
    static int[][] rs = new int[N][1005] ;

    static int func(int i,int sum) {
        if(i==N) {
            return 0;
        } 
        else if(rs[i][sum]!=-1) {
            return rs[i][sum] ;
        }
        else {
            if(a[i]<sum) {
                rs[i][sum] = func(i+1,sum-a[i]) + func(i+1,sum) +1 ;
            }
            else {
                rs[i][sum] = func(i+1,sum) ;
            }
            return rs[i][sum] ;
        }
    }

    public static void main(String[] args) {
        int i , j , n=a.length;
        for(i=0;i<n;i++) {
            for(j=0;j<1005;j++) {
                rs[i][j] = -1;
            }
        }
        int ans = func(0,k) ;
        System.out.println(ans);
    }
}

