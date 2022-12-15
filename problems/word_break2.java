import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class word_break2 {
    
    static ArrayList<String> ans = new ArrayList<>() ; 
    static String str;
    static int n ;
    static int test ;
    static HashSet <String> hs = new HashSet<>() ;
    static int rs[][] = new int[305][305] ;
    
    static void func(int i , int j,String s) {
        if(j==n-1) {
            test = 1;
            ans.add(s);
        }
        else {
            for(int k=j+1;k<n;k++) {
                // if(test==1) {
                //     break;
                // }
                if(rs[j+1][k]==-1) {
                    if(hs.contains(str.substring(j+1,k+1))) {
                        rs[j+1][k] = 1;
                        func(j+1,k,s+" "+str.substring(j+1,k+1)) ;   
                    }   
                    else {
                        rs[j+1][k] = 0;
                    }
                }
                else {
                    if(rs[j+1][k]==1) {
                        func(j+1,k,s+" "+str.substring(j+1,k+1)) ;   
                    }
                }
            }
        }
    } 
    
    public List<String> wordBreak(String s, List<String> wd) {
        ans.clear();
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
            // if(test==1) {
            //     break;
            // }
            if(hs.contains(str.substring(0,i+1))) {
                rs[0][i] = 1;
                func(0,i,s.substring(0,i+1)) ;   
            }  
            else {
                rs[0][i] = 0;
            }
        }
        return ans;
    }
}