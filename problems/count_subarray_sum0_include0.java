import java.util.*;

public class count_subarray_sum0_include0 {

    public static void main(String[] args) {

        int[] a = {0,-1,0,1,-1} ;
        HashMap<Integer,Integer> hm = new HashMap<>() ;
        int an = a.length, i=0,j , sum1=0, sum2=0,sum=0;

        hm.put(0,1) ;

        for(i=0;i<an;i++) {  // first counting subarrays with sum 0 but not including 0 
            if(a[i]==0) {
                sum=0;
                hm.clear() ;
                hm.put(0,1) ;
            } 
            else {
                sum += a[i] ;
                if(hm.containsKey(sum)) {
                    sum1 += hm.get(sum) ;
                    hm.put(sum,hm.get(sum)+1) ;
                }
                else {
                    hm.put(sum,1) ;
                }
            }
        }
        hm.clear() ;
        sum=0;
        sum2=0;
        hm.put(0,1) ;
        for(i=0;i<an;i++) {  // first counting subarrays with sum 0 (intcluding all) 
            sum += a[i] ;
            if(hm.containsKey(sum)) {
                sum2 += hm.get(sum) ;
                hm.put(sum,hm.get(sum)+1) ;
            }
            else {
                hm.put(sum,1) ;
            }
        }
        System.out.println(sum1 + " " + sum2  );   
    }
}
