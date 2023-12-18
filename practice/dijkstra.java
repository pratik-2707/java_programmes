import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;



public class dijkstra {
    static int N ;

    static int func(int s,int t,List<List<node>> g) {
        int[] d = new int[N+1] ;
        Arrays.fill(d,100000) ;
        d[s] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>(N,new node());
        pq.add(new node(s,0));

        while(pq.size()>0) {
            node curr = pq.poll() ;

            for(node it:g.get(curr.getV())) {
                if(d[curr.getV()]+it.getWt()<d[it.getV()]) {
                    d[it.getV()] = d[curr.getV()]+it.getWt() ;
                    pq.add(new node(it.getV(),d[it.getV()])) ;
                }
            }
        }

        return d[t] ;
    }

    public static void main(String[] args) {
        int i , j , n = 5;
        N = n;
        List<List<node>> adj = new ArrayList<>() ;

        for(i=0;i<n;i++) {
            adj.add(new ArrayList<node>()) ;
        }
        adj.get(0).add(new node(1, 2));
		adj.get(1).add(new node(0, 2));
		
		adj.get(1).add(new node(2, 4));
		adj.get(2).add(new node(1, 4));
		
		adj.get(0).add(new node(3, 1));
		adj.get(3).add(new node(0, 1));
		
		adj.get(3).add(new node(2, 3));
		adj.get(2).add(new node(3, 3));
		
		adj.get(1).add(new node(4, 5));
		adj.get(4).add(new node(1, 5));
		
		adj.get(2).add(new node(4, 1));
		adj.get(4).add(new node(2, 1));


        System.out.println( func(0,2,adj) );

    }
}

class node  implements Comparator<node>{
    int v;
    int wt;
    public int getV() {
        return this.v;
    }
    public int getWt() {
        return this.wt;
    }

    public node(int v,int wt) {
        this.v = v;
        this.wt = wt;
    }

    public node() {
        
    }

    @Override
    public int compare(node n1, node n2) {
        if(n1.wt<n2.wt) {
            return -1;
        }
        else if(n1.wt>n2.wt) {
            return 1;
        }
        return 0;
    }
}
