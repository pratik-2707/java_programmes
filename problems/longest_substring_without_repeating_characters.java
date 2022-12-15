import java.util.Arrays;

class longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        int[] rc = new int[256] ;
        Arrays.fill(rc,-1) ;
        int ans =0 , curr=0;
        for(int i=0;i<s.length();i++) {
            if(rc[s.charAt(i)]==-1) {
                rc[s.charAt(i)] = i;
                ans =  Math.max(ans,i-curr+1) ;
            }
            else {
                if(rc[s.charAt(i)]<curr) {
                    ans = Math.max(ans,i-curr+1) ;
                    rc[s.charAt(i)] = i ;
                }
                else {
                    curr = rc[s.charAt(i)] + 1;
                    ans = Math.max(ans,i-curr+1) ;
                    rc[s.charAt(i)] = i;
                }
            }
        }
        return ans;
    }
}