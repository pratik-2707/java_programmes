import java.util.HashMap;

public class subarray_count_with_givenxor {
    public int solve(int[] A, int B) {
        int count =  0 , cx = 0 , n = A.length ;
        HashMap <Integer,Integer> hm = new HashMap<>() ;
        for(int i=0;i<n;i++) {
            cx ^= A[i] ;
            if(cx==B) {
                if(hm.containsKey(cx^B)) {
                    count += hm.get(cx^B) ;   
                }
                count++;
            }
            else {
                if(hm.containsKey(cx^B)) {
                    count += hm.get(cx^B) ;
                }
            }
            
            if(!hm.containsKey(cx)) {
                hm.put(cx,1) ;    
            }
            else {
                int temp = hm.get(cx) ;
                hm.put(cx,temp+1) ;
            }
        }
        
        return count ;
    }
}
