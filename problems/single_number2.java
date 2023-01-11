public class single_number2 {


    static int bit_change(int n , int posn) {
        int i , j , mask ;
        if(set_bit_check(n, posn)) {
            mask = 1<<posn ;
            mask ^= (Integer.MAX_VALUE) ;
            return mask&n ;
        }
        else {
            mask = 1<<posn ;
            return mask|n ;
        }
    }

    static boolean set_bit_check(int n,int posn) {  // posn will be 0 index
        int i , j , mask ;
        mask = 1<<posn ;
        
        if((mask&n) !=0) {
            return true ;
        }
        else {
            return false;
        }
    }

    static int singleNumber(int[] nums) {
        int xor =0 , n = nums.length, i , j ;

        int[] rs = new int[70] ;
        for(i=0;i<n;i++) {
            for(j=0;j<32;j++) {
                if(set_bit_check(nums[i],j)) {
                    rs[j]++ ;
                }
            }
        }

        int ans  = 0;
        for(i=0;i<32;i++) {
            if((rs[i]%3)!=0) {
                ans = bit_change(ans,i) ;
            }
        }

        System.out.println(ans) ;
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {3,3,3,4,4,4,7} ;

        System.out.println(singleNumber(num)) ;
    }
}
