import java.util.ArrayList;
import java.util.Collections;

public class subarrays_with_atmost_kdiff_char {

    static int  func(int[] s, int k) {
        int i,j,n=s.length,ans=0 ,sz=0;
        ArrayList<Integer> mp = new ArrayList<>(Collections.nCopies(n+5, 0)) ;
        i=0;
        j=0;
        
        while(j<n) {
            if(mp.get(s[j])==0) {
                sz++;
            }
            mp.set(s[j], mp.get(s[j])+1) ;
            while(sz>k) {
                mp.set(s[i],mp.get(s[i])-1) ;
                if(mp.get(s[i])==0) {
                    sz--;
                }
                i++;
            }
            
            if(sz<=k) {
                ans += (j-i+1) ;
                j++;
            } 
        }

        return  ans;
    }

    public static void main(String[] args) {
        int[] a = {1,2,1,2,3} ;
        System.out.println(func(a,2));        
    }
}
