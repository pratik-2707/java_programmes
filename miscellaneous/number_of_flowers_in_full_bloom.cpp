
#include <bits/stdc++.h>
using namespace std ;

// https://leetcode.com/problems/number-of-flowers-in-full-bloom/

class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        vector<int> ans;
        vector<int> s;
        vector<int> e;
        for(int i=0;i<flowers.size();i++) {
            s.push_back(flowers[i][0]);
            e.push_back(flowers[i][1]);
        }
        int n = s.size() ;
        sort(s.begin(),s.end());
        sort(e.begin(),e.end());

        for(int i=0;i<people.size();i++) {
            if(people[i]<s[0] || people[i]>e[n-1]) {
                ans.push_back(0);
                continue;
            }
            int ind1 = upper_bound(s.begin(),s.end(),people[i])-s.begin() ;
            int ind2 = upper_bound(e.begin(),e.end(),people[i]-1)-e.begin() ;
            ans.push_back(ind1-ind2) ;
        }

        return ans ;
    }
};