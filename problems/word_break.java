import java.util.HashSet;

class Solution {

    // DYNAMIC PROGRAMMING
    static String str;
    static int n ;
    static int test ;
    static HashSet <String> hs = new HashSet<>() ;
    static int rs[][] = new int[305][305] ;
    
    static void func(int i , int j) {
        if(j==n-1) {
            test = 1;
        }
        else {
            for(int k=j+1;k<n;k++) {
                if(test==1) {
                    break;
                }
                if(rs[j+1][k]==-1) {
                    if(hs.contains(str.substring(j+1,k+1))) {
                        rs[j+1][k] = 1;
                        func(j+1,k) ;   
                    }   
                    else {
                        rs[j+1][k] = 0;
                    }
                }
            }
        }
    } 
    
    public boolean wordBreak(String s, List<String> wd) {
        n = s.length() ;
        str = s;
        test = 0;
        int i , j ;
        hs.clear();
        
        for(i=0;i<305;i++) {
            for(j=0;j<305;j++) {
                rs[i][j] = -1 ;
            }
        }
        
        for(i=0;i<wd.size();i++) {
            hs.add(wd.get(i)) ;
        }
        
        for(i=0;i<n;i++) {
            if(test==1) {
                break;
            }
            if(hs.contains(str.substring(0,i+1))) {
                rs[0][i] = 1;
                func(0,i) ;   
            }  
            else {
                rs[0][i] = 0;
            }
        }
        return test==1;
    }
}