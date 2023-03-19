import java.util.*;

public class maxm_xor_of_two_num {

    static class Node{
        Node[] children ;
        boolean eow;

        public Node() {
            children = new Node[2] ;
            for(int i=0;i<2;i++) {
                children[i] = null ;
            }
            eow = false;
        }
    }

    static Node root = new Node() ;

    static void insert(int num) {
        Node curr = root;
        int i,j,n=32 ;
        for( i=31;i>=0;i--) {  // O(word.length())
            int c = ((num>>i)&1) ;
            if(curr.children[c]!=null) {
                curr = curr.children[c] ;
            }
            else {
                Node temp = new Node() ;
                curr.children[c] = temp ;
                curr = temp ;
            }
            if(i==n-1) {
                curr.eow = true;
            }
        }
    }

    static int func(int n) { // return the maximum possible xor for each number
        int i , j ;
        int ret = 0;
        Node curr = root;
        for(i=31;i>=0;i--) {
            int c = ((n>>i)&1)  ;
            
            if(curr.children[c^1]!=null) {
                ret += (1<<i) ;
                curr = curr.children[c^1] ;
            }
            else {
                curr = curr.children[c] ;
            }
        }

        return ret ;
    }

    public static  int findMaximumXOR(int[] nums) {
        int i , j , n = nums.length;
        int ret = Integer.MIN_VALUE ;
        List<String> l = new ArrayList<>() ;
        for(i=0;i<2;i++) {
            root.children[i] = null;
        }
        for(i=0;i<n;i++) {
            insert(nums[i]);
        }
        for(i=0;i<n;i++) {
            ret = Math.max(ret,func(nums[i])) ;
        }
        return ret ;
    }

    public static void main(String[] args) {
       int[] nums =  {14,70,53,83,49,91,36,80,92,51,66,70} ;
       System.out.println(findMaximumXOR(nums));
    }
}
