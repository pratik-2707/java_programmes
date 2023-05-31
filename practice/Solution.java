import java.util.* ;

class pair {
    int first ;
    int second ;

    public pair() {}
    public pair (int f,int s) {
        this.first = f;
        this.second = s;
    }
}

class paircomparator implements Comparator<pair> {
    @Override
    public int compare(pair p1,pair p2) {
        if(p1.first<p2.first) {
            return 1;
        }
        else if(p1.first>p2.first){
            return -1;
        }
        else {
            return 0;
        }
    }
}


class Solution {
 
    static List<List<pair>> ans = new ArrayList<>(10) ;

    public static void main(String[] args)  {

        int[] ar = {1,2,3,4} ;
    }
}
