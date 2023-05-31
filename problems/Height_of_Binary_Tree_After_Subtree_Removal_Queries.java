import java.util.* ;

/**
 * Height_of_Binary_Tree_After_Subtree_Removal_Queries
 */

 class pair {
    int first ;
    int second ;

    public pair() {}
    public pair (int f,int s) {
        this.first = f;
        this.second = s;
    }
}

class paircomparator implements Comparator<pair> {
    @Override
    public int compare(pair p1,pair p2) {
        if(p1.second<p2.second) {
            return 1;
        }
        else if(p1.second>p2.second){
            return -1;
        }
        else {
            return 0;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    } 
}
 

public class Height_of_Binary_Tree_After_Subtree_Removal_Queries {


    static int[] ht = new int[100005] ;
    static int[] dpth = new int[100005] ;
    
    static List<List<pair>> ans = new ArrayList<>() ;

    static int func(TreeNode root,int d) {
        if(root!=null) {
            dpth[root.val] = d ;
            int l = func(root.left,d+1)+1 ;
            int r = func(root.right,d+1)+1 ;
            ht[root.val] = Math.max(l,r) ;
            ans.get(d).add(new pair(root.val,ht[root.val])) ;
            return ht[root.val] ;
        }
        else {
            return 0;
        }
    }

    static int[] treeQueries(TreeNode root, int[] queries) {
        int qn = queries.length, i , j ;
        Arrays.fill(ht,0) ;
        Arrays.fill(dpth,0) ;
        ans.clear() ;
        for(i=0;i<100005;i++) { 
            ans.add(new ArrayList<>());
        }
        func(root,0) ;
        for(i=0;i<100005;i++) {
            if(ans.get(i).size()>0) {
                // Collections.sort(ans.get(i),new paircomparator()) ;
                // or we can also write
                Collections.sort(ans.get(i),(p1,p2)->(p2.second-p1.second)) ;
            }
        }     
        for(i=0;i<qn;i++) {
            int curr = queries[i];
            if(ans.get(dpth[curr]).size()==1) {
                queries[i] = Math.max(dpth[curr]-1,0) ;
            }
            else {
                if(ans.get(dpth[curr]).get(0).first==curr) {
                    queries[i] = dpth[curr]+ans.get(dpth[curr]).get(1).second-1 ;
                }
                else {
                    queries[i] = dpth[curr]+ans.get(dpth[curr]).get(0).second-1 ;
                }
            }
        }
        return queries ;
    }

    public static void main(String[] args) {
        int[] queries = {5} ;

        TreeNode root = new TreeNode(4) ;
        root.left = new TreeNode(5) ;
        root.right = new TreeNode(6) ;

        System.out.println(treeQueries(root, queries)[0]);
    }
}