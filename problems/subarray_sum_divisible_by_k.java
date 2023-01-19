import java.util.HashMap;

public class subarray_sum_divisible_by_k {

    static int subarraysDivByK(int[] nums, int k) {
        int i,j,n = nums.length,ans=0,sum=0;
        HashMap<Integer,Integer> hm = new HashMap<>() ;
        hm.put(0,1) ;
        for(i=0;i<n;i++) {
            sum = ((sum%k + (nums[i]%k))+k)%k ; // here k is added for -ve remainder cases
            if (hm.containsKey(sum)) {
                ans += hm.get(sum);
            }
            hm.put(sum, hm.getOrDefault((sum), 0) + 1);
        }
        return ans ;
    }
    
    public static void main(String[] args) {
        int[] a = {4,5,0,-2,-3,1} ;
        System.out.println(subarraysDivByK(a,5)) ;
    }
}
