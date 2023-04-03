#include <bits/stdc++.h>
using namespace std;



    bool check(map<char,int> mp,int k) {
        for(auto jj:mp) {
            if(jj.second<k) {
                return false;
            }
        }
        return true ;
    }

    int func(string s, int k,char c) {
        map<char,int> mp ;
        int i =0, j=0 , n = s.length() , ret = 0 ;

        while(i<n && j<n) {
            if(i==j) {
                if(s[j]==c) {
                    mp.clear() ;
                    i++;j++;
                }
                else {
                    mp[s[j]]++;
                    if(check(mp,k)) {
                        ret = max(ret,j-i+1) ;
                    }
                    j++ ;
                }
            }
            else {
                if(s[j]==c) {
                    i = j+1 ;
                    j++ ;
                    mp.clear() ;
                }
                else {
                    mp[s[j]]++;
                    if(check(mp,k)) {
                        ret = max(ret,j-i+1) ;
                    }
                    j++ ;
                }
            }
        }
        return ret ;
    }

    int longestSubstring(string s, int k) {

        int i =0, j=0 , n = s.length() , ans=0;

        for(char it = 'a' ;it<='z';it++) {
            ans = max(ans,func(s,k,it)) ;
        }
        ans = max(ans,func(s,k,'#')) ;
        return ans ;
    }


int main () {

    int k = longestSubstring("baaabcb",3) ;
    cout<<k<<endl;
}