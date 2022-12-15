
import java.util.Scanner;
// BRUTE FORCE APPROACH O(n^2)
public class max_subarray_sum {
    public static void main(String[] args) {
        int i , j;
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr= new int[n+1] ;
            int[][] sum = new int[n+1][n+1] ;
            sum[0][0] = 0;
            arr[0] = 0;
            for(i=1;i<=n;i++) {
                arr[i] = sc.nextInt();
                arr[i] += arr[i-1] ;
                sum[0][i] = arr[i] ;
                System.out.println(arr[i] + " " + sum[0][i]);
            }
            int ans = Integer.MIN_VALUE ;
            for(i=1;i<=n;i++) {
                for(j=i;j<=n;j++) {
                    sum[i][j] = sum[0][j]-sum[0][i-1] ;
                    ans = Math.max(ans,sum[i][j]) ;
                }
            }
            System.out.println(ans);
        }
    }
}
