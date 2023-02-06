import java.util.ArrayList;
import java.util.List;


public class meet_inthe_middle {

    // finding all subsets such that they give sum x 
    // we can't use brute force because complexity
    // would be O(2^N)
    // but we can split array and half and then find sums 

    static List<Integer> func(int l, int r, int[] a) {
        // finding all subset sums
        int len = r - l + 1;
        List<Integer> res = new ArrayList<>();

        // loop through all subsets
        for (int i = 0; i < (1 << len); i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j))!=0) {
                    sum += a[l + j];
                }
            }
            res.add(sum);
        }
        return res;
    }



    public static void main(String[] args) {
        int n , x;
        n = 4;
        x = 5;
        int[] a = {1,2,2,3} ;

        List <Integer> left = func(0,n/2,a) ;
        List <Integer> right = func((n/2)+1,n-1,a) ;


        int ans = 0;

        for (Integer i: left) {
            int low_iterator = lower_bound(right.toArray(), x - i) ;
            int high_iterator = upper_bound(right.toArray(), x - i) ;
            int start_index = low_iterator ;
            int end_index = high_iterator ;
            ans += end_index - start_index;
        }
        System.out.println(ans);
    }
}
