public class segment_tree {

    static int[] a = new int[100005] ;
    static int[] sg = new int[4*100005] ;

    static void build(int ind,int low,int high) {
        if(low==high) {
            sg[ind] = low ;
            return;
        }
        int mid = low + (high-low)/2;
        build((2*ind)+1,low,mid) ;
        build((2*ind)+2,mid+1,high) ;
        sg[ind] = Math.max(sg[(2*ind)+1], sg[(2*ind)+2]) ;
    }

    static int query(int ind,int low,int high,int l,int r) {
        if(low>=l && high<=r) {
            return sg[ind] ;
        }
        if(high<l || low>r) {
            return Integer.MIN_VALUE;
        }
        int mid = (low+high)/2;
        int left = query(2*ind+1,low,mid,l,r) ;
        int right = query(2*ind+2,mid+1,high,l,r) ;
        return Math.max(left,right) ;
    }

    public static void main(String[] args) {
        int i ,j ;
        int n = 10;
        for(i=0;i<n;i++) {
            a[i] = i+1;
        } 
        build(0,0,n-1) ;
        System.out.println(query(0,0,n,0,n));
    }
}
