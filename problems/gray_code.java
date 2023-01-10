import java.util.ArrayList;
import java.util.List;

public class gray_code {

    static boolean set_bit_check(int n,int posn) {  // posn will be 0 index
        int i , j , mask ;
        mask = 1<<posn ;
        
        if((mask&n) >0) {
            return true ;
        }
        else {
            return false;
        }
    }

    static int bit_change(int n , int posn) {
        int i , j , mask ;
        if(set_bit_check(n, posn)) {
            mask = 1<<posn ;
            mask ^= (Integer.MAX_VALUE) ;
            return mask&n ;
        }
        else {
            mask = 1<<posn ;
            return mask|n ;
        }
    }

    static List<Integer> grayCode(int n) {
        int[] rs = new int[70000] ;
        List<Integer> ans = new ArrayList<>() ;

        int itr = (int)Math.pow(2,n) , i , j , comp = (int)Math.ceil((Math.log(n)/Math.log(2))) ;

        System.out.println(itr + " " + comp + " " ) ;
        for(i=0;i<itr;i++) {
            if(i==0) {
                ans.add(0) ; 
                rs[0] =1;       
            }
            else {
                for(j=0;j<n;j++) {
                    int num2 = bit_change(ans.get(ans.size()-1),j) ;
                    if(rs[num2]==0) {
                        ans.add(num2) ;
                        rs[num2] = 1;
                        break;
                    }
                }
            }
        }

        return ans ;
    }
    
    public static void main(String[] args) {
        List<Integer> list = grayCode(7) ;
        System.out.println(list);
    }
}
