package digit_dp;

// https://leetcode.com/problems/number-of-digit-one/

public class digit_one {

    static int rs[][][] = new int[10][2][10] ;

    static int func(String s,int i , int tight , int ct) {
        if(i==s.length()) {return ct ;}
        if(rs[i][tight][ct]!=-1) {return rs[i][tight][ct] ;} 
        int ret = 0, ub = 9;
        if(tight==1) {ub = s.charAt(i)-'0' ;} 

        for(int dig=0;dig<=ub;dig++) {
            if(dig==1) {
                int pass = ((tight==1)&&(dig==ub)) ? 1 : 0 ;
                ret += func(s,i+1,pass,ct+1) ;
            }
            else {
                int pass = ((tight==1)&&(dig==ub)) ? 1 : 0 ;
                ret += func(s,i+1,pass,ct) ;
            }
        }
        return rs[i][tight][ct] = ret ;
    }

    static int countDigitOne(int n) {
        String s = Integer.toString(n) ;
        for(int i=0;i<10;i++) {
            for(int j=0;j<2;j++) {
                for(int k=0;k<10;k++) {
                    rs[i][j][k] = -1;
                }
            }
        }
        return func(s,0,1,0) ;
        
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(34));
    }
}
