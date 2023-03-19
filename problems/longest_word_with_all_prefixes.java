import java.util.* ;

public class longest_word_with_all_prefixes {

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

    static String func(Node n) { // finding longest string such that eow will be true for each
        if(n==null) {
            return "";
        } else {
            int ret = 0 , i, comp=0;
            String st = "" ;
            for(i=0;i<26;i++) {
                if(n.children[i]!=null && n.children[i].eow==true) {
                    String temp = (char)(i+'a') + func(n.children[i]) ;
                    if(temp.length()>comp) {
                      comp = temp.length() ;
                      st = temp;
                    }
                }
            }
            return st ;
        }
    }

    static String find(String[] s) { 
        String st = "" ;
        int comp = 0;
        for(int i=0;i<26;i++) {
            root.children[i] =null;
        }
        for(String curr : s) {
            insert(curr) ;
        }

        for(int i=0;i<26;i++) {
          if(root.children[i]!=null && root.children[i].eow==true) {
            String temp = (char)(i+'a') + func(root.children[i]) ;
            if(temp.length()>comp) {
              st = temp;
              comp = temp.length() ;
            }    
          }     
        } 

        if(st.length()==0) {
          return "None" ;
        }
        else {
          return st;
        }
    }

    public static void main(String[] args) {
        int i , j ;
        String s[] = {"apple" , "app" ,"a", "ap" , "appl" ,"apply" , "banana"} ;
        System.out.println(find(s));
    }
}
