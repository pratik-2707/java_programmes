#include <bits/stdc++.h>

using namespace std ;

//  https://leetcode.com/problems/steps-to-make-array-non-decreasing/

class Solution {
public:
    int totalSteps(vector<int>& nums) {
        int i,j,n=nums.size(),ans=0 ;
        vector<pair<int,int>> v;

        for(i=n-1;i>=0;i--) {
            int ct=0, comp=0;
            while(v.size()>0) {
                auto top = v[v.size()-1] ;
                if(top.first<nums[i]) {
                    ct++;
                    ct = max(ct,top.second) ;
                    comp = max(comp,top.second);
                    v.pop_back();
                }
                else {
                    break;
                }
            }
            ans = max(ans,ct);
            v.push_back({nums[i],ct}) ;
        }

        return ans ;
    }
};