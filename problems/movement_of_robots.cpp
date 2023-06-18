#include <bits/stdc++.h>

using namespace std ;

// https://leetcode.com/contest/biweekly-contest-106/problems/movement-of-robots/

int sumDistance(vector<int>& nums, string s, int d) {
    int i, j , n = nums.size();long long  ans=0,pre=0, mod = 1e9+7;
    for(i=0;i<n;i++) {
        (s[i
        ]=='R')?(nums[i]+=d) :(nums[i]-=d) ;
    }
    sort(nums.begin(),nums.end()) ;
    pre += nums[0] ;
    for(i=1;i<n;i++) {
        ans = (ans%mod) + (((i%mod)*(nums[i]%mod))%mod-(pre%mod) + mod)%mod ;
        ans %= mod ;
        pre += nums[i] ;
        pre %= mod ;
    }
    return ans ;
}

int main() {
    vector <int> v  ={-2,0,2} ;
    string s = "RLL" ;
    int d = 3;
    cout<<sumDistance(v,s,d)<<endl;
}