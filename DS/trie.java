import java.util.* ;

public class trie {

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
                curr.children[c] = temp ;
                curr = temp ;
            }
            if(i==n-1) {
                curr.eow = true;
            }
        }
    }

    static boolean search(String word) {
        int i , j , n = word.length() ;
        Node curr = root;
        for(i=0;i<n;i++) {
            int c = word.charAt(i)-'a';
            if(i==n-1) {
                if(curr.children[c]==null) {
                    return false;
                } 
                else {
                    return curr.children[c].eow ; 
                }
            }
            else {
                if(curr.children[c]==null) {
                    return false;
                } 
                else {
                    curr = curr.children[c] ; 
                }
            }
        }
        return false;
    }

    static void print_trie(Node root) {
        Node curr = root;
        for(int i=0;i<26;i++) {
            if(curr.children[i]!=null) {
                // System.out.print((char)(i+'a') + " " );
                print_trie(curr.children[i]) ;
            }
        }
    }

    public static boolean startsWith(String prefix) {
        int i , j , n = prefix.length() ;
        Node curr = root;
        for(i=0;i<n;i++) {
            int c = prefix.charAt(i)-'a';
            if(curr.children[c]==null) {
                return false;
            } 
            else {
                curr = curr.children[c] ; 
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"there" ,"their" ,"them" ,"manali" ,"ganza","thatsit"} ;

        for(String jj : words) {
            insert(jj) ;
            System.out.println(search(jj));
        }
        print_trie(root) ;

        System.out.println(startsWith("gan"));
    }
}
