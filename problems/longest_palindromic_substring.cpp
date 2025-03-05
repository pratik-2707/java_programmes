#include <bits/stdc++.h>
using namespace std ;

//https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

// https://www.youtube.com/watch?v=UflHuQj6MVA&list=LL&index=1

// this solution will work in every test case , tested in gfg
 
string longestPalin (string s) {
    int n = s.length() , i , j  ;
    string ans = s.substr(0,1) ;
    int rs[n][n] ;
    
    for(i=0;i<n;i++) {    // every single letter will be palindrome
        rs[i][i] = 1;
    }

// every double letter string will be palindrome if s[i] = = s[i+1]
// and we are doing below thing because for 2 letter string , his condn wont work  s[lind+1] == s[rind-1]
    
    for(i=0;i<n-1;i++) {   
        rs[i][i+1] = (s[i]==s[i+1])? 1:0 ;
        if(rs[i][i+1]==1 && ans.length()<2) {
            ans = s.substr(i,2) ;
        }
    }
    
    for(i=2;i<n;i++) {
        for(j=0;j<n;j++) {
            if(j+i<n) {
                int lind = j , rind = i+j;
                rs[lind][rind] = ((rs[lind+1][rind-1]==1) && (s[lind]==s[rind])) ? 1:0 ;
                if(rind-lind+1>ans.length() && rs[lind][rind]==1) {
                    ans = s.substr(lind,rind-lind+1) ;
                }
            }
        }
    }
    
    return ans ;
}

int main() {
    string s = "hghrghgrhghivhifohvioeglkjwlg" ;
    cout<<longestPalin(s)<<endl;
}
