import java.util.HashMap;

public class count_no_of_good_subarrays {
    public static void main(String[] args) {
        long[] a = {3,1,4,3,2,2,4} ;
        int  i,j,n = a.length,curr=0,ans=0,l=0,r=-1,k;

        k = 2;
        HashMap<Long,Long> hm = new HashMap<>() ;
        while(l<n && r<n) {
            if(curr>=k) {
                ans += (n-r) ;
                curr -= (hm.get(a[l])-1) ;
                hm.put(a[l],hm.get(a[l])-1) ;
                l++;     
            }
            else {
                r++ ;
                while(r<n) {
                    if(hm.containsKey(a[r])!=false) {
                        hm.put(a[r],hm.get(a[r])+1) ;
                        curr += (hm.get(a[r])-1) ;
                        if(curr>=k) {
                            ans += (n-r) ;
                            curr -= (hm.get(a[l])-1) ;
                            hm.put(a[l],hm.get(a[l])-1) ;
                            l++;
                            break;
                        }
                        r++ ;
                    }   
                    else {
                        hm.put(a[r],(long)1) ;
                        if(curr>=k) {
                            ans += (n-r) ;
                            curr -= (hm.get(a[l])-1) ;
                            hm.put(a[l],hm.get(a[l])+1) ;
                            l++;
                            break;
                        }
                        r++;
                    }
                }   
            }
        }
        System.out.println(ans);
    }
}
