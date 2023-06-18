package digit_dp;

import java.util.* ;

// https://leetcode.com/list/relyabt5/ digit dp problems

// https://leetcode.com/problems/count-of-integers/description/?envType=list&envId=relyabt5

/**
 * basic 
 */
public class basic {

    // programme will calculate how many numbers lying between l and r satisfy this condition f(x) = y

    static int[][][] rs = new int[1000][300][2] ;

    static int func(String r , int n , int x , boolean tight) {
        if(x<0) {
            return 0 ;
        }

        if(n==1) {
            if(x>=0 && x<=9) {
                return 1;
            }
            else {
                return 0 ;
            }
        }

        int thd = (tight==true) ? 1 : 0 ;
        if(rs[n][x][thd]!=-1) {
            return rs[n][x][thd] ;
        }

        int ub = (tight) ? r.charAt(r.length()-n)-'0' : 9;
        int ans = 0;

        for(int dig=0;dig<=ub;dig++) {
            if(dig==ub) {
                ans += func(r,n-1,x-dig,tight) ;
            }
            else {
                ans += func(r,n-1,x-dig,false) ;
            }
        }
        return rs[n][x][thd] = ans ;
    }

    public static void main(String[] args) {
        String r = "11235" ;
        String l = "" ;
        int sum = 5 ;
        for(int i=0;i<rs.length;i++) {
            for(int j=0;j<rs[i].length;j++) {
                for(int k=0;k<rs[i][j].length;k++) {
                    rs[i][j][k] = -1;
                }
            }
        }
        System.out.println(func(r,r.length(),sum,true)); 
    }
}