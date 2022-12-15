import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class dfs {

    static Vector<Vector<Integer>> g = new Vector<Vector<Integer>>() ;
    static boolean[] vis = new boolean[101] ;

    static void func() {
        for(int i = 0;i<50;i++) {
            Vector<Integer> a = new Vector<>() ;
            g.add(a) ;
        }
    } 

    static void func1(int vertex) {
        vis[vertex] = true ;

        for(int child:g.get(vertex)) {
            if(!vis[child]) {
                System.out.println(vertex + " " + child);
                func1(child) ;
            }
        }
    }

    public static void main(String[] args) {
        func() ;
        Arrays.fill(vis, false);
        Scanner sc = new Scanner( System.in) ;
        int vertex = sc.nextInt();
        int edges = sc.nextInt() ;
        for(int i=0;i<edges;i++) {
            int v1 , v2 ;
            v1 = sc.nextInt();
            v2 = sc.nextInt() ;
            g.get(v1).add(v2) ;
            g.get(v2).add(v1) ;
        }
        func1(1) ;
        // System.out.println(g);
    }
}


//  7 6 1 2 1 3 2 4 2 5 3 6 3 7   input