import java.util.* ;
import java.io.*; 

import java.util.ArrayList;	


// first we will add all left side nodes
// then all leaf nodes 
// then all right side nodes

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class boundary_traversal_of_binary_tree {

	static ArrayList<Integer> ans = new ArrayList<>() ;

	static boolean isleaf(TreeNode root) {
		if(root.left==null && root.right==null) {
			return true ;
		}
		else {
			return false;
		}
	}

	static void func_left(TreeNode root) {
		if(root!=null) {
			if(!isleaf(root)) {
				ans.add(root.data) ;
				if(root.left==null) {
					func_left(root.right) ;
				}
				else {
					func_left(root.left) ;
				}
			}
		}
	}

	static void func_leaf(TreeNode root) {
		if(root!=null) {
			if(isleaf(root)) {
				ans.add(root.data) ;
			}
			else {
				func_leaf(root.left) ;
				func_leaf(root.right) ;
			}
		}
	}

	static void func_right(TreeNode root) {
		if(root!=null) {
			if(!isleaf(root)) {
				if(root.right==null) {
					func_right(root.left) ;
				}
				else {
					func_right(root.right) ;
				}
				ans.add(root.data) ;
			}
		}
	}

	public static  ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
		ans.clear() ;
		if(root==null) {
			return ans ;
		}
		else {
			if(isleaf(root)) {
				ans.add(root.data) ;
				return ans;
			}
			else {
				ans.add(root.data) ;
				func_left(root.left) ;
				func_leaf(root) ;
				func_right(root.right) ;
			}
			return ans ;
		}
	}

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1) ;
        root.left = new TreeNode(2) ;
        root.right = new TreeNode(3) ;

        ArrayList <Integer> a =new ArrayList<>() ;
        a = traverseBoundary(root) ;
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }
}