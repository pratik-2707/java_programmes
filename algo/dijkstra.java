import java.util.*;


class node implements Comparator<node>{
    int v;
    int wt;
    public int getV() {
        return v;
    }
    public int getWt() {
        return wt;
    }

    node() {}

    node(int v,int wt) {
        this.wt = wt;
        this.v = v;
    }

    @Override
    public int compare (node n1, node n2){
        if(n1.wt<n2.wt) {
            return -1;
        }
        else if(n1.wt>n2.wt) {
            return 1;
        }
        return 0;
    }
}



public class dijkstra {

    static int N ;

    static void func(int s, List<List<node>> g) {
        int dist[] = new int[N];
        for(int i = 0;i<N;i++) dist[i] = 100000000;
        dist[s] = 0; 
        PriorityQueue<node> pq = new PriorityQueue<node>(N,new node());
        pq.add(new node(s, 0));

        while(pq.size()>0) {
            node curr = pq.poll() ;

            for(node it : g.get(curr.getV())) {
                if(dist[curr.getV()]+it.getWt()<dist[it.getV()]) {
                    dist[it.getV()] = dist[curr.getV()]+it.getWt() ;
                    pq.add(new node(it.getV(), dist[it.getV()]));
                }
            }
        }

        for(int i=0;i<N;i++) {
            System.out.println(dist[i]);
        }
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

        func(0,adj) ;
    }
}
