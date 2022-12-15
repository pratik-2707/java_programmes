import java.util.Scanner;
// KADANE'S ALGORITHM
public class max_subarray_sum2 {

    static int func(int[] a) {
        int curr_sum = a[1] ;
        int curr_max = a[1] ;
        
        for(int i=2;i<a.length;i++) {
            curr_sum += a[i] ;
            curr_sum = Math.max(curr_sum,a[i]) ;
            if(curr_sum>curr_max) {
                curr_max = curr_sum ;
            }
        }
        return curr_max ;
    }
    public static void main(String[] args) {
        int i , j;
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr= new int[n+1] ;
            for(i=1;i<=n;i++) {
                arr[i] = sc.nextInt();
            }
            final int ans = func(arr) ;
            System.out.println(ans);
            sc.close();
        }
    }
}
