import java.util.*;
import java.io.* ;
 
// problem link : https://cses.fi/problemset/task/1668
 
public class Main {
 
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
  
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
  
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
  
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
  
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
  
            if (neg)
                return -ret;
            return ret;
        }
  
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
  
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
  
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
  
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
  
            if (neg)
                return -ret;
            return ret;
        }
  
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
  
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
  
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
 
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
                if(vis[curr]==c) {  // if c==1 so vis[curr] should be 2 , but if vis[curr]==c , which is 1 then test = false
                    test = false;
                }
            }
        }
    }
 
    public static void main(String[] args) throws IOException {
        int i , j , n , m , x ,y;
        Reader io = new Reader();
        n = io.nextInt() ;
        m  = io.nextInt() ;
 
        List<List<Integer>> g = new ArrayList<>() ;
        int[] vis = new int[n+5] ;  // 0 means not visited , 1 means class 1 , 2 means class 2
        for(i=0;i<=n;i++) {
            g.add(new ArrayList<>()) ;
        }
 
        for(i=0;i<m;i++) {
            x = io.nextInt() ;
            y = io.nextInt() ;
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
            System.out.println() ;
        }
        else {
            System.out.println("IMPOSSIBLE");
        }
    }
}