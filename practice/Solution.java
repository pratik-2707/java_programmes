import java.util.* ;

class node  {
    int v ;
    int wt;

    node() {}

    node(int v, int wt) {
        this.v = v ;
        this.wt = wt;
    }
}

class nodecomparator implements Comparator<node> {
    @Override
    public int compare (node p1,node p2) {
        if(p1.wt<p2.wt) {
            return -1 ;
        }
        else {
            return 1;
        }

    }
}

class Solution {
    
    static ArrayList<ArrayList<node>> g = new ArrayList<>() ;

    static void func(int s) {

        Queue<node> q = new LinkedList<>() ;
        int n = 10 ;
        int dist[] = new int[n];
        for(int i = 0;i<n;i++) dist[i] = 100000000;
        dist[s] = 0;

        PriorityQueue<node> pq = new PriorityQueue<node>(new nodecomparator());
        pq.add(new node(s, 0));


        while(pq.size()>0) {
            node curr = pq.poll() ;

            for(node it : g.get(curr.v)) {
                if(dist[curr.v]+it.wt<dist[it.v]) {
                    dist[it.v] = dist[curr.v]+it.wt ;
                    pq.add(new node(it.v,dist[it.v])) ;
                }
            }
        }

        for(int i=0;i<n;i++) {
            System.out.println(dist[i]);
        }

    }

    public static void main(String[] args)  {
        for(int i=0;i<1000;i++) {
            g.add(new ArrayList<node>()) ;
        }

        g.get(0).add(new node(1, 2));
		g.get(1).add(new node(0, 2));
		
		g.get(1).add(new node(2, 4));
		g.get(2).add(new node(1, 4));
		
		g.get(0).add(new node(3, 1));
		g.get(3).add(new node(0, 1));
		
		g.get(3).add(new node(2, 3));
		g.get(2).add(new node(3, 3));
		
		g.get(1).add(new node(4, 5));
		g.get(4).add(new node(1, 5));
		
		g.get(2).add(new node(4, 1));
		g.get(4).add(new node(2, 1));

        func(0) ;

    }
}
