import java.util.* ;

public class count_unique_substrings {

    static int ans ;

    static class Node{
        Node[] children ;
        boolean eow;

        public Node() {
            children = new Node[26] ;
            for(int i=0;i<26;i++) {
                children[i] = null ;
            }
            eow = false;
        }
    }

    static Node root = new Node() ;

    static void insert(String word) {
        Node curr = root;
        int i,j,n=word.length() ;
        for( i=0;i<n;i++) {  // O(word.length())
            int c = word.charAt(i)-'a' ;
            if(curr.children[c]!=null) {
                curr = curr.children[c] ;
            }
            else {
                Node temp = new Node() ;
                ans++ ;
                curr.children[c] = temp ;
                curr = temp ;
            }
            if(i==n-1) {
                curr.eow = true;
            }
        }
    }

	public static int countDistinctSubstrings(String s) {
        ans=0;
        for(int i=0;i<26;i++) {
            root.children[i] = null;
        }
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                insert(s.substring(i, j+1)) ;
            }
        }
        // answer will be number of nodes created + 1(empty substring) 
        return ans +1 ;
        
    }


    public static void main(String[] args) {
        System.out.println(countDistinctSubstrings("sds"));
        System.out.println(countDistinctSubstrings("abc"));

    }
}
