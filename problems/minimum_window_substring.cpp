#include <bits/stdc++.h>
using namespace std ;

    string minWindow(string s, string t) {
        int i , j ,n = s.length() , tn = t.length() ,curr=0,ans=INT_MAX;
        string ret = "" ;
        unordered_map<char,int> mpt;
        for(i=0;i<tn;i++) {
            mpt[t[i]]++;
        }
        int req = mpt.size() ;
        i=0;j=0;
        vector<int> v(200,0) ;
        
        while(j<n) {
            v[s[j]]++;

            while(i<n) {
                if(mpt.find(s[i])==mpt.end()) {
                    v[s[i]]--;
                    i++;
                }
                else {
                    if(v[s[i]]>mpt[s[i]]) {
                        v[s[i]]--;
                        i++;
                    }
                    else {
                        break;
                    }
                }
            }

            bool test = true  ;
            for(auto jj:mpt) {
                if(v[jj.first]<mpt[jj.first]) {
                    test=false;
                    break;
                }
            }
            if(test) {
                if((j-i+1)<ans) {
                    ans = (j-i+1) ;
                    ret = s.substr(i,(j-i+1)) ;
                }
            }
            j++;
        } 
        return ret;
    }

    int main() {
        string s= "ADOBECODEBANC" , t = "ABC" ;
        cout<<minWindow(s,t)<<endl;
    }