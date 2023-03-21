package cses;
import java.util.*  ;

public class minimum_coin_sum {
    public static void main(String[] args) {
        int t,i,j,k,l,r,mid,n,m,c,d,x,y ,curr=0,sum,ans,temp;
        int[] a = {1,3,4,5,7,7} ;
        n = a.length ;
        Arrays.sort(a) ;
        sum=0;
        for(i=0;i<n;i++) {
            if((a[i]-curr)>1) {
                System.out.println(curr+1);
                return  ;
            }
            curr += a[i] ;
        }
        System.out.println(curr+1);
    }
}
