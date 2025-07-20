#include<bits/stdc++.h>
using namespace std;
#define ll long long 

// https://leetcode.com/problems/number-of-integers-with-popcount-depth-equal-to-k-i/

// this problem is little unique because in this we actually use binary conversion of n to check while in recursion our 
// number is less than it
// for exmaple 4 => 1 0 0 
//   we can go for  0 1 1 , because tight got 0
//                  0 0 0
//but when tight=1) 1 1   , we can't do this 
// we can =>        1 0 0  do this so basically using binary represenation of n for tight comparison and function call 

class Solution {

ll rs[61][61][2] ;
ll pop_ct[61] ;
    
ll func(ll i,ll ct,ll tight,ll n,ll k) {
    if(i==-1) {
        return (pop_ct[ct]+1==k)?1:0 ;
    }
    else if(rs[i][ct][tight]!=-1) {
        return rs[i][ct][tight] ;
    }
    ll is_bit_set = ((((ll)1<<i)&n)!=0)?1:0;
    if(tight) {
        // we can go for 0 as well as 1
        if(is_bit_set) {
            return rs[i][ct][tight] = func(i-1,ct,0,n,k) + func(i-1,ct+1,tight,n,k) ;
        }
        else {
            return rs[i][ct][tight] = func(i-1,ct,tight,n,k) ;
        }
    }
    else {
        return rs[i][ct][tight] = func(i-1,ct,0,n,k) + func(i-1,ct+1,0,n,k) ;
    } 
}
    
public:
    long long popcountDepth(long long n, int k) {
        ll i , j ;
        memset(rs,-1,sizeof(rs)) ;
        pop_ct[0] = -1;
        pop_ct[1] = 0;
        for(i=2;i<=60;i++) {
            pop_ct[i] = pop_ct[__builtin_popcount(i)]+1 ;
        }
        ll ret = func(60,0,1,n,k) ;
        return (k==1)?ret-1:ret;
    }
};