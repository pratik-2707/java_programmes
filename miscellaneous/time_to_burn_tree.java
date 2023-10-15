
// https://www.codingninjas.com/studio/problems/time-to-burn-tree_1469067?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

/**
 * time_to_burn_tree
 */
public class time_to_burn_tree {

    static class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}


	static class pair{
		boolean foundStart ;
		int maxm;
		public pair(boolean foundStart,int maxm) {
			this.foundStart = foundStart;
			this.maxm = maxm;
		}
	}

	static int ans;

	static pair func(BinaryTreeNode<Integer> node,int start) {
		if(node!=null) {
			pair pl = func(node.left,start);
			pair pr = func(node.right,start);

			if(node.data==start) {
				ans = Math.max(pl.maxm,pr.maxm) ;
				return new pair(true,1);	
			}
			else {
				if(pl.foundStart) {
					ans = Math.max(ans,pl.maxm+pr.maxm);
					return new pair(true,pl.maxm+1);
				}
				else if(pr.foundStart){
					ans = Math.max(ans,pr.maxm+pl.maxm);
					return new pair(true,pr.maxm+1);
				}
				else {
					return new pair(false,Math.max(pl.maxm,pr.maxm)+1);
				}
			}
		}
		return new pair(false,0);
	}

    static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
		ans = 0;
		func(root,start) ;
		return ans ;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(5) ;
        root.left = new BinaryTreeNode<Integer>(6) ;
        root.right = new BinaryTreeNode<Integer>(7) ;
        System.out.println("time to burn tree  : " + timeToBurnTree(root, 5)   );
        
    }
}