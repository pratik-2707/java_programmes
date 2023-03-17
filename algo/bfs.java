import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class bfs {

    static Vector<Vector<Integer>> g = new Vector<Vector<Integer>>() ;
    static boolean[] vis = new boolean[101] ;

    static void func() {
        for(int i = 0;i<50;i++) {
            Vector<Integer> a = new Vector<>() ;
            g.add(a) ;
        }
    } 

    static void func1(int source) {
        vis[source] = true ;
        Queue <Integer> q = new LinkedList<>() ;
        q.add(source) ;

        while(!q.isEmpty()) {
            int curr = q.peek() ;
            for(Integer child :g.get(curr)) {
                if(!vis[child]) {
                    vis[child] = true;
                    System.out.println(child);
                    q.add(child) ;
                }
            }
            q.remove() ;
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
            v1 = sc.nextInt() ;
            v2 = sc.nextInt() ;
            g.get(v1).add(v2) ;
            g.get(v2).add(v1) ;
        }
        func1(1) ;
        // System.out.println(g);
    }
}


// 7 6 1 2 1 3 2 4 2 5 3 6 3 7 input