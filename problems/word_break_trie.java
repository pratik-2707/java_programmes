import java.util.* ;

public class word_break_trie {

    static int[] dp = new int[305] ;
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
                System.out.print((char)(i+'a') + " " );
                print_trie(curr.children[i]) ;
            }
        }
        System.out.println();
    }

    public static boolean func(int i,String s) {
        int n = s.length() ;
        if(i>=n) {
            return true ;
        }
        if(dp[i]!=-1) {
            if(dp[i]==1) {
                return true;
            }
            return false;
        }
        boolean test = false;
        for(int j=i;j<n;j++) {
            System.out.println(i+" " + s.substring(i, j+1) + search(s.substring(i,j+1)));
            if(search(s.substring(i,j+1))) {
                test |=  func(j+1,s) ;
            }
        }
        if(test) {
            dp[i] =1;
        }
        else {
            dp[i] = 0;
        }
        return test;
    }
    
    public static boolean wordBreak(String s, List<String> wd) {
        for(int i=0;i<26;i++) {
            root.children[i] = null;
        }
        Arrays.fill(dp,-1) ;
        for(String st:wd) {
            insert(st) ;
        }
        return func(0,s) ;
    }

    public static void main(String[] args) {
        List <String> l = new ArrayList<>() ;
        l.add("aaa");l.add("aaaa") ;
        System.out.println(wordBreak("aaaaaaa",l));
    }
}
