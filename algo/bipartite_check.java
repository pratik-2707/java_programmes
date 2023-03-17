import java.util.*;

// problem link : https://cses.fi/problemset/task/1668

public class bipartite_check {

    static boolean test;

    static void func(int v, List<List<Integer>> g,int[] vis, int c) {
        
        vis[v] = c ;

        for(int i=0;i<g.get(v).size();i++) {
            int curr=g.get(v).get(i) ;
            if(vis[curr]==0) {
                if(c==1) {
                    func(curr,g,vis,2) ;
                }
                else {
                    func(curr,g,vis,1) ;
                }
            }
            else {
                if(vis[curr]==c) {
                    test = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int i , j , n , m , x ,y;
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt() ;
        m  = sc.nextInt() ;

        List<List<Integer>> g = new ArrayList<>() ;
        int[] vis = new int[n+5] ;  // 0 means not visited , 1 means class 1 , 2 means class 2
        for(i=0;i<=n;i++) {
            g.add(new ArrayList<>()) ;
        }

        for(i=0;i<m;i++) {
            x = sc.nextInt() ;
            y = sc.nextInt() ;
            g.get(x).add(y) ;
            g.get(y).add(x) ;
        }
        test = true;
        for(i=1;i<=n;i++) {
            if(vis[i]==0) {
                func(i,g,vis,1) ;
            }
        }

        if(test) {
            for(i=1;i<=n;i++) {
                System.out.print(vis[i] + " " ) ;
            }
            System.out.println();
        }
        else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
