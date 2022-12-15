
class Solution {
    static int[][] rc = new int[1005][1005] ;

    public int longestValidParentheses(String s) {
        for (int i = 0; i < rc.length; i++) {
            rc[i][i] = 1;
        }
        int cmp = 0 ;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                int l = i ;
                int r = j ;
                if(i>0 && j<s.length()-1)  {
                    if(s.charAt(i-1)==s.charAt(j+1)) {
                        if(rc[i-1][j+1]==1) {
                            rc[i][j] = 1;
                            continue;
                        }
                        else {
                            rc[i][j] = 0;
                            continue;
                        }
                    }
                }
                boolean test = true ;
                int tester  = 0 ;
                for (int k = l; k <= r; k++) {
                    if(s.charAt(k)=='(') {
                        tester++;
                    }
                    else {
                        tester-- ;
                    }
                    if(tester<0) {
                        test = false;
                    }
                }
                if (test) {
                    if(tester==0) {
                        rc[i][j] = 1;
                        if ((j-i+1)>cmp) {
                            cmp = j-i+1 ;
                            System.out.println(cmp) ;
                        }
                    }
                }
            }
        }
        return cmp ;
    }
}
