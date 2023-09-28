import java.util.*;
import java.lang.*;

public class Main {

	static class node {
		node[] children ;
		boolean eow ;

		public node() {
			children = new node[26] ;
			for(int i=0;i<26;i++) {
				children[i] = null ;
			}
			eow = false;
		}
	}

	static node root = new node() ; 

	static void insert(String s) {
		node curr = root ;
		int i , j , n = s.length() ;

		for(i=0;i<n;i++) {
			int c = s.charAt(i)-'a' ;

			if(curr.children[c]!=null) {
				curr = curr.children[c] ;
			}
			else {
				curr.children[c] = new node() ;
				curr = curr.children[c] ;
			}
			if(i==n-1) {
				curr.eow = true ;
			}
		}
	}

	static boolean search(String s) {
		node curr = root ;
		int i , j , n = s.length() ;
		for(i=0;i<n;i++) {
			int c = s.charAt(i)-'a' ;
			if(curr.children[c]!=null) {
				curr = curr.children[c] ;
			}
			else {
				return false;
			}
			if(i==n-1) {
				return curr.eow ;
			}
		}
		return false;
	}
    
	public static void main (String[] args) {

		int i,j,n;
        String[] words = {"there" ,"their" ,"them" ,"manali" ,"ganza","thatsit"} ;

        for(String jj : words) {
            insert(jj) ;
            // System.out.println(search(jj));
        }

		System.out.println(search("there"));
	}
}

