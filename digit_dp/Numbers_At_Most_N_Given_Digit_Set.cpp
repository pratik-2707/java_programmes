#include <bits/stdc++.h> 
using namespace std ;

int rs[11][2][2] [2];
int a[10] ;

// https://leetcode.com/problems/numbers-at-most-n-given-digit-set/description/?envType=list&envId=relyabt5

int func(string s , int i,bool tight, bool ispres, bool zapp) {
    if(i==s.length()) {
        if(ispres) {
            if(zapp) {
                return (a[0]>0) ? 1:0 ;
            }
            else {
                return 1 ;
            }
        }
        else {
            return 0;
        }
    }
    else if(rs[i][tight][ispres][zapp]!=-1) {
        return rs[i][tight][ispres][zapp] ;
    }
    else {
        int dig , ub , ret=0 ;
        ub = (tight) ? (s[i]-'0') : 9;

        for(dig=0;dig<=ub;dig++) {
            if(zapp) {
                if(dig==0) {
                    ret += func(s,i+1,(tight&&(ub==dig)),ispres,zapp) ;
                }
                else {
                    ret += func(s,i+1,(tight&&(ub==dig)),(((a[dig]>0)&&ispres)),false) ;
                }
            }
            else {
                if(ispres) {
                    ret += func(s,i+1,(tight&&(ub==dig)),(((a[dig]>0)&&ispres)),zapp) ;
                }
                else {
                    ret += func(s,i+1,(tight&&(ub==dig)),false,zapp) ;
                }
            }
        } 
        return rs[i][tight][ispres][zapp] = ret ;
    }
}

int atMostNGivenDigitSet(vector<string>& digits, int n) {
    int i , j , dn=digits.size();
    memset(a,0,sizeof(a)) ;
    memset(rs,-1,sizeof(rs)) ;
    for(i=0;i<dn;i++) {
        a[stoi(digits[i])]++ ;
    }
    string s = to_string(n) ;
    return func(s,0,1,1,1) ;
}

int main () {
    vector<string> v = {"1","3","5","7"};
    int n= 100 ;
    cout<<atMostNGivenDigitSet(v,n)<<endl;
}
