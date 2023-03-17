import java.util.*;


// https://leetcode.com/problems/count-palindromic-subsequences/description/


public class count_palindromic_subsequences {

    public static int countPalindromes(String s) {
        int len = s.length();
        if (len < 5) {
            return 0;
        }
        
        int mod = 1000000007;
        int[] cnt = new int[10];
        
        cnt[s.charAt(0) - '0']++;
        
        long[][][] left = new long[len][10][10];
        long[][][] right = new long[len][10][10];
        
        for (int i = 1; i < len; i++) {
            int curr = s.charAt(i) - '0';
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < 10; n++) {
                    left[i][m][n] = left[i-1][m][n];
                }
            }
            for (int j = 0; j < 10; j++) {
                left[i][j][curr] += cnt[j];
            }
            cnt[curr]++;
        }
        
        Arrays.fill(cnt, 0);

        cnt[s.charAt(len-1) - '0']++;
        for (int i = len-2; i >= 0; i--) {
            int curr = s.charAt(i) - '0';
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < 10; n++) {
                    right[i][m][n] = right[i+1][m][n];
                }
            }
            for (int j = 0; j < 10; j++) {
                right[i][curr][j] = right[i+1][curr][j] + cnt[j];
            }
            cnt[curr]++;
        }
        
        long res = 0;
        
        for (int i = 2; i < len-2; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    res = (res + left[i-1][j][k] * right[i+1][k][j]) % mod;
                }
            }
        }
        return (int)res;
    }


    public static void main(String[] args) {
        System.out.println(countPalindromes("130031"));
    }
}
