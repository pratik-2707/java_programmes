#include <bits/stdc++.h>

using namespace std ;



#define ll long long 

class Solution {
    
    ll mn , mx ;
    
    bool check1(ll num) {
        if(num!=mn) {
            return true ;
        }
        return false;
    }
    
    bool check2(ll num) {
        if(num!=mx) {
            return true ;
        }
        return false;
    }
    
    bool check3(ll num) {
        if(num!=mx && num!=mn) {
            return true ;
        }
        return false;
    }

    bool check4(ll num) {
        if(num>=mn && num<=mx) {
            return true ;
        }
        return false;
    }

    ll func1 (int st , int n,vector<int>&nums) {
        int ret = 0 , curr=0 , i=st , j =st ;
        
        while(i<n && j<n) {
            if(check1(nums[j])) {
                j++ ;
            }
            else {
                ll temp = (j-i) ;
                ret += (temp*(temp+1))/2 ;
                i = j+1 ;
                j++ ;
            }
        }
        cout<<"grte"<<ret<<endl;
        ll temp = (j-i) ;
        ret += (temp*(temp+1))/2 ; 
        cout<<"grte"<<ret<<endl;
        return ret ;
    } 
    
    ll func2(int st , int n,vector<int>&nums) {
        int ret = 0 , curr=0 , i=st , j =st ;
        
        while(i<n && j<n) {
            if(check2(nums[j])) {
                j++ ;
            }
            else {
                ll temp = (j-i) ;
                ret += (temp*(temp+1))/2 ;
                i = j+1 ;
                j++ ;
            }
        }
        ll temp = (j-i) ;
        ret += (temp*(temp+1))/2 ; 
        
        return ret ;
    } 
    
    ll func3(int st , int n,vector<int>&nums) {
        int ret = 0 , curr=0 , i=st , j =st ;
        
        while(i<n && j<n) {
            if(check3(nums[j])) {
                j++ ;
            }
            else {
                ll temp = (j-i) ;
                ret += (temp*(temp+1))/2 ;
                i = j+1 ;
                j++ ;
            }
        }
        ll temp = (j-i) ;
        ret += (temp*(temp+1))/2 ; 
        
        return ret ;
    } 

    ll func4(int st , int n , vector<int>v) {
        int  i=st , j=st , ct=0;
        for(int it=st;it<n;it++) {
            if(v[it]==mn || v[it]==mx) {
                ct++ ;
            }
        }
        ll vn = n-st ;
        ll total = (vn*(vn+1))/2 ;
        ll sub_exclmnm = func1(st,n,v) ; 
        ll sub_exclmxm = func2(st,n,v) ;
        ll exclmnmandmxm = func3(st,n,v) ;
        ll onlymnm = sub_exclmnm - exclmnmandmxm ;
        ll onlymxm = sub_exclmxm - exclmnmandmxm ;
        cout<<st<<' '<<n<<endl;
        cout<<total<<" "<<sub_exclmnm<<" "<<sub_exclmxm<<" "<<exclmnmandmxm<<endl;
        return (total-(onlymnm+onlymxm+exclmnmandmxm)) ;
    }

public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        mn = minK  ; mx = maxK ;
        ll i =0, j=0 , n = nums.size() , ans=0 ;

        while(i<n && j<n) {
            if(check4(nums[j])) {
                j++ ;
            }
            else {
                ll temp = func4(i,j,nums) ;
                ans += temp ;
                i = j+1;
                j++ ;
            }
        }
        ans += (func4(i,j,nums)) ;

        return ans;
    }
};
      