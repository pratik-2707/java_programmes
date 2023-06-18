import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class concatenated_words {

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
    static int[] rs = new int[31] ;

    static int func(int i ,String s) {
        if(i>=s.length()) {
            return 1;
        }
        else if(rs[i]!=-1) {
            return rs[i] ;
        }
        else {
            int ret = 0;
            for(int j=i+1;j<=s.length();j++) {
                if(search(s.substring(i,j))) {
                    ret |= func(j,s) ;
                }
            }
            return rs[i] = ret ;
        }
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        int i , j , n = words.length;
        Set<String> ans = new HashSet<>() ;
        for(i=0;i<26;i++) {
            root.children[i] = null ;
        }
        for(String s:words) {
            insert(s) ;
        }
        for(i=0;i<n;i++) {
            Arrays.fill(rs,-1) ;
            for(j=1;j<words[i].length();j++) {
                if(search(words[i].substring(0,j))) {
                    if( func(j,words[i])==1) {
                        ans.add(words[i]) ;
                    }
                }
            }
        }
        List<String> ans2 =  new ArrayList<>(ans) ;
        return ans2 ;
    }

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};

        System.out.println(findAllConcatenatedWordsInADict(words));
    }
}
