import java.util.Arrays;


public class allocate_books {
    public static  int books(int[] a, int b) {
        int l = 0 , r = Arrays.stream(a).sum() ,mid =0, i , j , curr=0 , currsum , n = a.length , test,ans=-1;
        if(b>n) {
            return -1;
        }
        while(l<=r) {
            mid = l + (r-l)/2;
            test=1;curr=0;
            for(i=1;i<=b;i++) {
                currsum =  0 ; 
                
                while(curr<n && (currsum+a[curr])<=mid) {
                    currsum += a[curr] ;
                    curr++;
                } 
                
                if(currsum>mid) {
                    test=0;
                    break;
                }
            }
            if(curr<n) {
                test=0;
            }
            if(test==1) {
                ans = mid;
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        
        if(ans==-1) {
            return -1;
        }
        else {
            return ans;   
        }
    }

    public static void main(String[] args) {
        int[] rs =  {1 , 2 , 3, 4} ;
        System.out.println(books(rs,2));
    }
}
