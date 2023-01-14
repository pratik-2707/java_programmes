class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        return root[x];
    }
		
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
            return true;
        }
        else {
            // return true when both the node has same root node
            // and this will be the last edge which will form a circle
            return false;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

public class reductant_connection {
    static void findRedundantConnection(int[][] edges) {
        int i , j , n = edges.length ;

        UnionFind uf = new UnionFind(n) ;

        int[] ans = new int[2] ;

        for(i=0;i<n;i++) {
            if(uf.union(edges[i][0]-1,edges[i][1]-1)) {
                continue;
            }
            else {
                ans[0] = edges[i][0] ;
                ans[1] = edges[i][1] ;
                System.out.println(ans[0] + " " + ans[1]);
            }
        }

    }

    public static void main(String[] args) {
        int[][] edges ={{1,2},{1,3},{2,3}};
        findRedundantConnection(edges);
    }
}