//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class GFG {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int tc = scan.nextInt();
    
            while (tc-- > 0) {
                int N = scan.nextInt();
                int M = scan.nextInt();
                int E = scan.nextInt();
    
                boolean graph[][] = new boolean[N][N];
    
                for (int i = 0; i < E; i++) {
                    int u = scan.nextInt() - 1;
                    int v = scan.nextInt() - 1;
                    graph[u][v] = true;
                    graph[v][u] = true;
                }
    
                System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    class solve {
    
        static int N  , M ;
        static int test ;
        static int[] color = new int[25] ;
        
        // gv : graph vertex , cr : color 
        static boolean check(int gv , int cr,boolean[][] graph) {
            int test2 = 1 ;
            for(int i=0;i<N;i++) {
                if(graph[gv][i]) {
                    if(color[i]!=-1) {
                        if(color[i]==cr) {
                            test2 = 0;
                            break;
                        }
                    }   
                }
            }
            if(test2==1) {
                return true;
            }
            else {
                return false;
            }
        }
        
        static void func(int ind,boolean[][] graph) {
            if(ind==N) {
                test = 1;
            }
            
            else {
                for(int i=1;i<=M;i++) {
                    if(test==1) {
                        break;
                    }
                    if(check(ind,i,graph)) {
                        color[ind] = i;
                        func(ind+1,graph) ;
                    }
                }
            }
        }
        
        public boolean graphColoring(boolean graph[][], int m, int n) {
            // Your code here
            int i , j ;
            N = n ;
            M = m ;
            Arrays.fill(color,-1) ;
            test = 0 ;
            for(i=1;i<=M;i++) {
                color[0] = i; 
                func(1,graph) ; 
                if(test==1) {
                    break;
                } 
            }
            
            return test==1 ;
        }
    }