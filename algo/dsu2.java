import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union_set(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        } else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}

public class dsu2 {

    static  int numberOfGoodPaths(int[] vals, int[][] edges) {
        int  i , j , n=vals.length , ans=0;

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>() ;

        for(i=0;i<n;i++) {
            ArrayList<Integer> a = new ArrayList<>() ;
            tree.add(a) ;
        }

        TreeMap<Integer,ArrayList<Integer>> hm = new TreeMap<>() ;

        for(i=0;i<edges.length;i++) {
            tree.get(edges[i][0]).add(edges[i][1]) ;
            tree.get(edges[i][1]).add(edges[i][0]) ;
        }


        for(i=0;i<n;i++) {
            if(hm.get(vals[i])==null) {
                ArrayList<Integer> temp = new ArrayList<>() ;
                temp.add(i) ;
                hm.put(vals[i],temp) ;
            }
            else {
                ArrayList<Integer> temp = hm.get(vals[i]) ;
                temp.add(i) ;
                hm.put(vals[i],temp) ;
            }
        }

        UnionFind uf = new UnionFind(n);

        for(Map.Entry<Integer,ArrayList<Integer>> entry : hm.entrySet()) {
            // here we will add nodes to dsu and check for different groups if any
            // for each there will be no of nodes of same values

            int currval = entry.getKey() ;
            for(Integer node : entry.getValue()) {
                
                for(i=0;i<tree.get(node).size();i++) {
                    if(vals[tree.get(node).get(i)]<=currval) {
                        uf.union_set(tree.get(node).get(i),node) ;
                    }
                }
            }
            Map<Integer, Integer> group = new HashMap<>();
            // Iterate over all the nodes. Get the set of each node and increase the count
            // of the set by 1.
            for (int u : hm.get(entry.getKey())) {
                group.put(uf.find(u), group.getOrDefault(uf.find(u), 0) + 1);
            }

            for (int key : group.keySet()) {
                int size = group.get(key);
                ans += size * (size + 1) / 2;
            }
        }

        return ans ;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{2,3},{2,4}} ;
        int[] vals = {1,3,2,1,3} ;

        System.out.println(numberOfGoodPaths(vals, edges));
    }
}
