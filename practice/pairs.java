import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// we can make this class as static class also inside pairs class

class pair  {
    int first ;
    int second ;
    
    public pair() {}
    public pair (int f,int s) {
        this.first = f;
        this.second = s;
    }
}



public class pairs {

    public static int lower_bound(ArrayList<Integer> ar, int k)
    {
        int s = 0, e = ar.size();
        while (s != e)
        {
            int mid = s + e >> 1;
            if (ar.get(mid) <= k)
            {
                s = mid + 1;
            }
            else
            {
                e = mid;
            }
        }
        return Math.abs(s) - 1;
    }
 
    public static int upper_bound(ArrayList<Integer> ar, int k)
    {
        int s = 0;
        int e = ar.size();
        while (s != e)
        {
            int mid = s + e >> 1;
            if (ar.get(mid) < k)
            {
                s = mid + 1;
            }
            else
            {
                e = mid;
            }
        }
        if (s == ar.size())
        {
            return -1;
        }
        return s;
    }

    static class Sorting implements Comparator<pair>{
        @Override
        public int compare(pair o1, pair o2) {
            // TODO Auto-generated method stub
            if(o2.second==o1.second){
                return o2.first-o1.first;
            }
            return o2.second - o1.second;
        }
    }
    
    public static  void main(String[] args) {

        List <pair> arr = new ArrayList<pair>() ;
        pair z  = new pair(1, 2) ;
        arr.add(z) ;
        for(pair it : arr) {
            System.out.println(it.first + " " + it.second);
        }

        Collections.sort(arr,new Sorting()) ;
        for(pair it : arr) {
            System.out.println(it.first + " " + it.second);
        }

        
    }
}
