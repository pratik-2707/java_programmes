import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class template {

//4 Direction 
static int[] dx = new int[] {1,0,-1,0}; 
static int[] dy = new int[] {0,1,0,-1}; 

//8 direction
// static int[] dx = new int[]{1,1,0,-1,-1,-1,0,1}; 
// static int[] dy = new int[]{0,1,1,1,0,-1,-1,-1}; 
 
//Knight Direction (horse)
// static int[] dx = new int[]{2,1,-1,-2,-2,-1,1,2}; 
// static int[] dy = new int[]{1,2,2,1,-1,-2,-2,-1};

    static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try { 
                    st=new StringTokenizer(br.readLine());				               
                } catch (IOException e) {}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}  

    static class Pair<A, B> {
        A first;
        B second;
  
        // Constructor
        public Pair(A first, B second)
        {
            this.first = first;
            this.second = second;
        }
    }

    public static int lower_bound(ArrayList<Integer> ar, int k)
    {
        int s = 0, e = ar.size();
        while (s != e)
        {
            int mid = s + e >> 1;
            if (ar.get(mid) <= k)
            {
                s = mid + 1;
            }
            else
            {
                e = mid;
            }
        }
        return Math.abs(s) - 1;
    }
 
    public static int upper_bound(ArrayList<Integer> ar, int k)
    {
        int s = 0;
        int e = ar.size();
        while (s != e)
        {
            int mid = s + e >> 1;
            if (ar.get(mid) < k)
            {
                s = mid + 1;
            }
            else
            {
                e = mid;
            }
        }
        if (s == ar.size())
        {
            return -1;
        }
        return s;
    }

    
    public static void main(String[] args) {
        FastScanner fs = new FastScanner() ;
        int a = fs.nextInt() ;
        System.out.println(a);
    }
}



// BufferedReader br = new BufferedReader(
//                                new FileReader("input.txt"));
 
//         // PrintWriter class prints formatted representations
//         // of objects to a text-output stream.
//         PrintWriter pw=new PrintWriter(new
//                 BufferedWriter(new FileWriter("output.txt")));
 
//         // Your code goes Here
 
//         pw.flush();