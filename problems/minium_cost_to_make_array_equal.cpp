#include <bits/stdc++.h>
using namespace std ;

#define ll long long int
class Solution {
    
    static bool comp(const pair<ll,ll> &p1,const pair<ll,ll> &p2) {
        return p1.first<p2.first ;
    }
    
public:
    long long minCost(vector<int>& nums, vector<int>& cost) {
        ll i , j , n = nums.size() ; ll ans=LONG_LONG_MAX;
        
        ll rs[100005] = {0},rs2[100005]={0} , b[100005] = {0} , c[100005]={0};
        vector<pair<ll,ll>> v;
        for(i=0;i<n;i++) {
            v.push_back({nums[i],cost[i]}) ;
        }
        sort(v.begin(),v.end(),comp) ;
        
        for(i=0;i<n;i++) {
            if(i==0) {
                b[i] = v[i].second ;
            }
            else {
                b[i] += (b[i-1]+v[i].second) ;
            }
            cout<<b[i]<<" ";
        }
        cout<<endl;
        for(i=n-1;i>=0;i--) {
            if(i==n-1) {
                c[i] = v[i].second ;
            }
            else {
                c[i] += (c[i+1]+v[i].second) ;
            }
            // cout<<c[i]<<" ";
        }
        
        cout<<endl;
        
        for(i=0;i<n;i++) {
            if(i==0) {
                rs[i] = 0;
            }
            else {
                rs[i] = rs[i-1] + (b[i-1]*(v[i].first-v[i-1].first)) ; 
            }
            // cout<<rs[i]<<" ";
        }

        for(i=n-1;i>=0;i--) {
            if(i==n-1) {
                rs2[i] = 0;
            }
            else {
                rs2[i] = rs2[i+1] + (c[i+1]*(v[i+1].first-v[i].first)) ; 
            }
            // cout<<rs2[i]<<" ";
        }
        
        for(i=n-1;i>=0;i--) {
            if(i==n-1) {
                ans = min(ans,rs[i]) ;
                cout<<rs[i]<<" ";
            }
            else if(i==0) {
                ans = min(ans,rs2[i]) ;
                cout<<rs2[i]<<" ";
            }
            else {
                ans = min(ans,rs[i]+rs2[i]) ;
                cout<<rs[i]+rs2[i]<<" ";
            }
            
        }
        
        return ans;
    }
};