#include <bits/stdc++.h>

using namespace std ;

#define ll long long

// problem link : https://leetcode.com/problems/minimum-number-of-operations-to-make-arrays-similar/description/?orderBy=most_votes


class Solution {
public:
    long long makeSimilar(vector<int>& nums, vector<int>& t) {
        ll i , j , n = nums.size() ;
        vector<int> o ;
        vector<int> e;
        sort(nums.begin(),nums.end()) ;
        sort(t.begin(),t.end()) ;
        for(i=0;i<n;i++) {
            if(nums[i]%2==0) {
                e.push_back(nums[i]) ;
            }
            else {
                o.push_back(nums[i]) ;
            }
        }

        ll oi=0 , ei=0, sum=0 ;

        for(i=0;i<n;i++) {
            if(t[i]%2==0) {
                sum += abs(t[i]-e[ei]) ;
                ei++ ;
            }
            else {
                sum += abs(t[i]-o[oi]) ;
                oi++ ;
            }
        }

        return sum/4;
    }
};