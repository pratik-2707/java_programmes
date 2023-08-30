 #include <bits/stdc++.h>
using namespace std ;


    int func(int i,vector<string> & s, char first, char last) {
        if(i==s.size()) {
            return 0;
        }
        
        else {
            int ret = INT_MAX;
            // adding current one in last
            
            if(last==s[i][0]) {
                int temp = func(i+1,s,s[i][s[i].length()-1],first)+(s[i].length()-1) ;
                ret = min(temp,ret) ;
            }
            else {
                int temp = func(i+1,s,s[i][s[i].length()-1],first)+s[i].length() ;
                ret = min(temp,ret) ;
            }
            
            
            // adding current one in front 
            
            if(first==s[i][s[i].length()-1]) {
                int temp = func(i+1,s,s[i][0],first)+s[i].length()-1 ;
                ret = min(temp,ret) ;
            }
            else {
                int temp = func(i+1,s,s[i][0],first)+s[i].length() ;
                ret = min(temp,ret) ;
            }            
            
            return ret ;
        }
    }