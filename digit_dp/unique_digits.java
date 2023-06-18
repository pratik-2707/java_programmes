package digit_dp;

public class unique_digits {

    // https://leetcode.com/problems/count-numbers-with-unique-digits/?envType=list&envId=relyabt5

    static int countNumbersWithUniqueDigits(int n) {
        int i , j , ans=0 , curr=1 , add=9;
        int[] rs = new int[n+1] ;
        rs[0] = 1;
        for(i=1;i<=n;i++) {
            if(i!=1 && i!=2) {
                add-- ;
            }
            curr *= add ;
            rs[i] = rs[i-1] + (curr) ;
        }
        return rs[n] ;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(7));
    }
}
