import java.util.* ;

public class largest_cycle_ingraph {
    static ArrayList<ArrayList<Integer>> g = new ArrayList<>() ;

    static int func (int s,int n) {
        int[] dpth = new int[n] ;
        Arrays.fill(dpth,-1) ;
        int ret = Integer.MIN_VALUE;
        Queue<Integer> q = new LinkedList<>() ;
        dpth[s] = 0;
        q.add(s) ;
        while(q.size()>0) {
            int top = q.poll() ;

            for(int i=0;i<g.get(top).size();i++) {
                int curr = g.get(top).get(i) ;
                if(dpth[curr]!=-1)  {
                    if(dpth[curr]>=dpth[top] ) {
                        System.out.println(curr + " " + top  + dpth[curr]) ;
                        ret = Math.max(ret,dpth[curr]+dpth[top]+1);
                    } 
                }
                else {
                    dpth[curr]  = dpth[top]+1 ;
                    q.add(curr) ;
                } 
            }
        }
        return ret ;
    }

    static  int findlargestCycle(int n, int[][] edges) {
        g.clear() ;
        int i , j, en  =edges.length , ans=Integer.MIN_VALUE;
        for(i=0;i<n;i++) {
            g.add(new ArrayList<Integer>()) ;
        }
        for(i=0;i<en;i++) {
            g.get(edges[i][0]).add(edges[i][1]) ;
            g.get(edges[i][1]).add(edges[i][0]) ;
        }

        for(i=0;i<n;i++ ) {
            ans = Math.max(func(i,n),ans) ;
        }
        if(ans==Integer.MIN_VALUE) {
            return -1 ;
        }
        else{
            return ans ;
        }
    }

    public static void main(String[] args) {
        int[][] edges  = {{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}} ;
        int n = 7;

        System.out.println(findlargestCycle(n, edges));
    }
}
