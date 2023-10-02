//  https://leetcode.com/contest/biweekly-contest-111/problems/number-of-beautiful-integers-in-the-range/

// here condition was that if even and odd count is equal and number should be divisible by k 
// for checking whether a no is divisible by k or not  , i passed remainder and on every index new product 
// will be ((rem*10)+dig)%k

// i am also using st as a indicator that while recursion a number greater than 0 occuredor not 
// if not we can't compare even and odd , or we say we will pass 0 , if current num is 0


#include <bits/stdc++.h>
using namespace std;

#define mod 1000000007

class Solution {
    
int rs[10][2][10][10][21][2];
    
int func(string s , int i,bool tight,int even,int odd,int rem,int k,int st) {
    if(i==s.length()) {
        return (even==odd && rem==0) ? 1 : 0; 
    }
    else if(rs[i][tight][even][odd][rem][st]!=-1) {
        return rs[i][tight][even][odd][rem][st]%mod ;
    }
    else {
        int dig , ub , ret=0 ;
        ub = (tight) ? (s[i]-'0') : 9;

        for(dig=0;dig<=ub;dig++) {
            int pass = ((rem*10)+dig)%k ;
            if(st==0) {
                if(dig%2==0) {
                    ret = ((ret%mod) + (func(s,i+1,(tight&&(ub==dig)),(dig!=0),odd,pass,k,(dig!=0)))% mod)%mod ;
                }
                else {
                    ret = ((ret%mod) + (func(s,i+1,(tight&&(ub==dig)),even,(dig!=0),pass,k,(dig!=0)))% mod)%mod ;
                }
            }
            else {
                if(dig%2==0) {
                    ret = ((ret%mod) + (func(s,i+1,(tight&&(ub==dig)),even+1,odd,pass,k,st))% mod)%mod ;
                }
                else {
                    ret = ((ret%mod) + (func(s,i+1,(tight&&(ub==dig)),even,odd+1,pass,k,st))% mod)%mod ;
                }   
            }
        } 
        
        return rs[i][tight][even][odd][rem][st] = (ret)%mod ;
    }
}
    
public:
    int numberOfBeautifulIntegers(int low, int high, int k) {
        string sl = to_string(low-1);
        string sr = to_string(high) ;
        
        memset(rs,-1,sizeof(rs)) ;
        int t1 = func(sl,0,1,0,0,0,k,0) ;
        memset(rs,-1,sizeof(rs)) ;
        int t2 = func(sr,0,1,0,0,0,k,0) ;
        
        cout<<t1<<" "<<t2<<endl;
        
        return (t2%mod - t1%mod + mod)%mod;
    }
};