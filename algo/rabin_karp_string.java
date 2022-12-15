public class rabin_karp_string {
    static boolean check(String s,String sub,int i , int j) {
        int test = 1 , it , ind=0;
        for(it=i;it<=j;it++) {
            if(s.charAt(it)!=sub.charAt(ind)) {
                test = 0;
                break;
            }
            ind++;
        }
        return test==1 ;
    }
    
    static int func(String s,String sub) {
        int n = s.length();
        int m = sub.length() ;
        int i ,j , ha =0, hb=0, mp=1;
        
        for(i=0;i<m;i++) {
            ha += (s.charAt(i)) ;
            hb += (sub.charAt(i)) ;
        }
        if(ha==hb) {
            if(check(s,sub,0,m-1)) {
                return 0 ;
            }
        }
        for(i=1;i<n-m+1;i++) {
            ha -= s.charAt(i-1) ;
            ha = ((ha) + (s.charAt(i+m-1))) ;
            if(ha==hb) {
                if(check(s,sub,i,i+m-1))  {
                    return i;
                }
            }
        }
        return -1;
    }
     
    public static void main(String[] args) {
        String s = "pratik" ;
        String sub = "tik" ;
        // sub's length should be less than s's length
        if(s.length()<sub.length()) {
            System.out.println(-1);
        }
        else {
            System.out.println(func(s,sub));
        }
    }
}
