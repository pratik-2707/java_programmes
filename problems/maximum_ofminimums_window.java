import java.util.* ;
import java.io.*; 
public class maximum_ofminimums_window {
    
   
    static int[] nextSmallerElement(int[] nums1) {
        ArrayList<Integer> a = new ArrayList<>() ;
        int rs[] = new int[nums1.length] ;
        Arrays.fill(rs,-1) ;
        int i , j , n = nums1.length;
        for(i=0;i<n;i++) {
            if(i==0) {
                a.add(i) ;
            }
            else {
                while(true) {
                    if(a.size()>0) {
                        int ind = a.get(a.size()-1);
                        if(nums1[ind]>nums1[i]) {
                            rs[ind] = i ;
                            a.remove(a.size()-1) ;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                a.add(i) ;
            }
        }
        return rs ;
    }
 
    static int[] nextSmallerElement2(int[] nums1) {
        ArrayList<Integer> a = new ArrayList<>() ;
        int rs[] = new int[nums1.length] ;
        Arrays.fill(rs,-1) ;
        int i , j , n = nums1.length;
        for(i=n-1;i>=0;i--) {
            if(i==n-1) {
                a.add(i) ;
            }
            else {
                while(true) {
                    if(a.size()>0) {
                        int ind = a.get(a.size()-1);
                        if(nums1[ind]>nums1[i]) {
                            rs[ind] = i ;
                            a.remove(a.size()-1) ;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                a.add(i) ;
            }
        }
        return rs ;
    }

    
    public static int[] maxMinWindow(int[] a, int n) {
        int i , j ;
        // Write your code here
        int[] fwd = nextSmallerElement(a) ;
        int[] bwd = nextSmallerElement2(a) ;
        
        // array which contain maximum width up to which
        // particular index element can be minimum
        
        int[] w = new int[n] ;
        
        for(i=0;i<n;i++) {
            // minimum element in array
            // width will be n
            if(bwd[i]==-1 && fwd[i]==-1) {
                w[i] = n ;
            }
            else if(bwd[i]!=-1 && fwd[i]==-1) {
                w[i] = n - bwd[i] -1;
            }
            else if(bwd[i]==-1 && fwd[i]!=-1) {
                w[i] = fwd[i] ;
            }
            else  {
                w[i] = fwd[i] - bwd[i] - 1 ;
            }
        }
        
        int[] ans = new int[n] ;
        int mxm = 1000000009 ;
        Arrays.fill(ans,mxm) ;
        
        for(i=0;i<n;i++) {
            if(ans[w[i]-1]==mxm)  {
                ans[w[i]-1] = a[i] ;
            }
            else {
               ans[w[i]-1] = Math.max(a[i],ans[w[i]-1]) ; 
            }
            
        }
        
        for(i=n-2;i>=0;i--) {
            if(ans[i]==mxm) {
                ans[i] = ans[i+1] ;
            }
            else {
                ans[i] = Math.max(ans[i],ans[i+1]) ;
            }
        }
        
        return ans ;
    }
}

