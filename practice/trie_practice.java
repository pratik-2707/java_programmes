import java.util.* ;

import org.w3c.dom.Node;

public class trie_practice {

    static class node {
        node[] children ;
        boolean eow ;

        public node() {
            children = new node[26] ;
            for(int i=0;i<26;i++) {
                children[i] = null;
            }
            eow=  false;
        }
    }

    static node root = new node() ;

    static void insert(String s) {
        node curr = root;
        int i , j , n = s.length() , c;

        for(i=0;i<n;i++) {
            c = s.charAt(i)-'a' ;
            if(curr.children[c]!=null) {
                curr = curr.children[c] ;
            }
            else {
                node a = new node() ;
                curr.children[c] =  a ;
                curr = a; 
            }

            if(i==n-1) {
                curr.eow = true ;
            }
        }
    }

    static boolean search(String s) {
        node curr = root;
        int i , j , n = s.length() , c;

        for(i=0;i<n;i++) {
            c = s.charAt(i)-'a' ;
            if(curr.children[c]!=null) {
                curr = curr.children[c] ;
            }
            else {
                return false;
            }
        }
        return curr.eow ;
    }

    static void print_trie(trie_practice.node root) {
        node curr = root;
        for(int i=0;i<26;i++) {
            if(curr.children[i]!=null) {
                System.out.print((char)(i+'a') + " " );
                print_trie(curr.children[i]) ;
            }
        }
    }


    public static void main(String[] args) {
        String[] words = {"there" ,"their" ,"them" ,"manali" ,"ganza","thatsit"} ;

        for(String jj : words) {
            insert(jj) ;
            System.out.println(search(jj));
        }

        print_trie(root) ;

        // System.out.println(startsWith("gan"));
    }
}
