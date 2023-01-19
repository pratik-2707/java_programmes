public class maxm_sum_circular_subarray {

        static int max_sub_sum(int[] a) {
            int curr_sum = a[0] ;
            int curr_max = a[0] ;
            
            for(int i=1;i<a.length;i++) {
                curr_sum += a[i] ;
                curr_sum = Math.max(curr_sum,a[i]) ;
                if(curr_sum>curr_max) {
                    curr_max = curr_sum ;
                }
            }
            System.out.println("max" + " " +curr_max) ;
            return curr_max ;
        }
    
        static int min_sub_sum(int[] a) {
            int curr_sum = 0 ;
            int curr_min = 0 ;
            
            for(int i=0;i<a.length;i++) {
                curr_sum += a[i] ;
                curr_sum = Math.min(curr_sum,a[i]) ;
                if(curr_sum<curr_min) {
                    curr_min = curr_sum ;
                }
            }
            System.out.println("min " + curr_min) ;
            return curr_min ;
        }
    
        static int maxSubarraySumCircular(int[] nums) {
    
            int i , j , n = nums.length , ind ,sum=0;
            for(i=0;i<n;i++) {
                sum += nums[i] ;
            }
            int temp = min_sub_sum(nums) ;
            if(sum==temp) {
                return max_sub_sum(nums) ;
            }
            else {
                return Math.max(sum-temp,max_sub_sum(nums)) ;
            }
        }
    


    public static void main(String[] args) {
        int[] a = {5,-3,5};
        System.out.println(maxSubarraySumCircular(a));
    }
}
