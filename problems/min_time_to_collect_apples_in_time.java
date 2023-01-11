import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * min_time_to_collect_apples_in_time
 */
public class min_time_to_collect_apples_in_time {

    static int[] vis = new int[100000] ;

    static int func (int node,List<Boolean> hasapple,ArrayList<ArrayList<Integer>> tree ) {
        int i , j , ret=0;
        vis[node] = 1;

        for(i=0;i<tree.get(node).size();i++) {
            if(vis[tree.get(node).get(i)]==0) {
                ret += func(tree.get(node).get(i),hasapple,tree) ;
            }
        }

        if(node==0) {
            return ret ;
        }
        else {
            if(hasapple.get(node)) {
                return ret + 2;
            }
            else {
                if(ret>0) {
                    return ret + 2;
                }
                else {
                    return ret ;
                }
            }
        }
    }

    static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>() ;

        int i , j , en = edges.length;

        for(i=0;i<n;i++) {
            ArrayList<Integer> a = new ArrayList<>() ;
            tree.add(a) ;
        }
        for(i=0;i<en;i++) {
            tree.get(edges[i][0]).add(edges[i][1]) ;
            tree.get(edges[i][1]).add(edges[i][0]) ;
        }
        Arrays.fill(vis,0) ;
        return func(0,hasApple,tree) ;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{0,3}};

        List<Boolean> hasapple = new ArrayList<>() ;
        hasapple.add(true) ;
        hasapple.add(true) ;
        hasapple.add(true) ;
        hasapple.add(true) ;
        System.out.println(minTime(4,edges,hasapple)) ;
    }
}