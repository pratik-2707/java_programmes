#include <bits/stdc++.h>

using namespace std ;

class Solution {

    int vis[105] ;

    int rs[105][105][105] ;

    int func(vector <pair<int,int>> &a ,int i,int j,int ext) {
        if(i>j) {
            return 0;
        }
        else if(rs[i][j][ext]!=-1) {{
            return rs[i][j][ext] ;
        }}
        else {
            int k,l,n=a.size() ,ret=0,curr=a[i].second , num= a[i].first;
            ret = max(func(a,i+1,j,0) + (curr+ext)*(curr+ext),ret)  ;
            for(k=i+1;k<=j;k++) {
                if(num==a[k].first) {
                    ret = max(ret,func(a,i+1,k-1,0)+func(a,k,j,ext+curr)) ;
                }
            }
            return rs[i][j][ext] = ret ;
        }
    }


public:
    int removeBoxes(vector<int>& b) {
        int i , j , n = b.size() ;

        vector<pair<int,int>> v;
        v.push_back({b[0],1}) ;
        memset(rs,-1,sizeof(rs)) ;
        for(i=1;i<n;i++) {
            if(v[v.size()-1].first==b[i]) {
                v[v.size()-1].second += 1;
            }
            else {
                v.push_back({b[i],1}) ;
            }
        }
        return func(v,0,v.size()-1,0) ;
    }
};