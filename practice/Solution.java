import java.util.* ;

class Solution {
    
    static ArrayList <ArrayList<Integer>> a = new ArrayList<>() ;
    public static void main(String[] args)  {
        
        ArrayList <Integer> b = new ArrayList<>() ;
        a.add(new ArrayList<>()) ;
        a.get(0).add(1) ;
        b.add(1) ;
        if(a.get(0).get(0)==b.get(0)) {
            System.out.println("rge");
        }
    }
}
