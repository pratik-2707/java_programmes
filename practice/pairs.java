import java.util.ArrayList;
import java.util.List;


// we can make this class as static class also inside pairs class

class Pair<A, B> {
    A first;
    B second;

    // Constructor
    public Pair(A first, B second)
    {
        this.first = first;
        this.second = second;
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

    public static  void main(String[] args) {

        List <Pair<Integer,Integer>> a = new ArrayList<Pair<Integer,Integer>>() ;
        Pair<Integer,Integer> z  = new Pair<Integer,Integer>(1, 2) ;
        a.add(z) ;
        for(Pair<Integer,Integer> it : a) {
            System.out.println(it.first);
        }
    }
}


// class pair<a,b> {
//     a first ;
//     b second ;
    
//     public pair (a f,b s) {
//         this.first = f;
//         this.second = s;
//     }
// }