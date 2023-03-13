import java.util.*;
import java.lang.*;



public class aggressive_cows {
    
	public static void main (String[] args) throws java.lang.Exception
	{
		int a[] = {1,2,4,8,9} ;
        int i ,n = a.length ,ind, j ,l = 0 ,curr=0, r = (int)1e9 , mid=0 , ans =0 , test=0 , c = 3;

        Arrays.sort(a);
        while(l<=r) {

            mid = l + (r-l)/2 ;
            test=1;ind=0;curr=0;

            for(i=1;i<=c;i++) {
                if(i==1) {
                    curr=a[ind] ;ind++;
                }
                else {
                    while(ind<n && a[ind]-curr<mid ) {
                        ind++;
                    }
                    if(ind<=n-1) {
                        curr = a[ind] ;
                    } 
                    else {
                        test=0;
                        break;
                    }

                }

            }

            if(i<c) {
                test=0;
            }

            if(test==1) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        System.out.println(ans);
	}
}



