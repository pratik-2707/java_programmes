#include <bits/stdc++.h> 
using namespace std ;


int rs[11][2][2][2][11];
int a[10] ;

int func(string s , int i,bool tight, bool isdupl, bool zapp,int ct) {
    if(i==s.length()) {
        if(!isdupl) {
            return (zapp) ? 0 : 1; 
        }
        else {
            return 0;
        }
    }
    else if(rs[i][tight][isdupl][zapp][ct]!=-1) {
        return rs[i][tight][isdupl][zapp][ct] ;
    }
    else {
        int dig , ub , ret=0 ;
        ub = (tight) ? (s[i]-'0') : 9;

        for(dig=0;dig<=ub;dig++) {
            if(zapp) {
                if(dig==0) {
                    ret += func(s,i+1,(tight&&(ub==dig)),isdupl,zapp,ct) ;
                }
                else {
                    a[dig]++ ;
                    int temp = func(s,i+1,(tight&&(ub==dig)),((a[dig]>1)||isdupl),false,ct+1) ;
                    ret += temp ;
                    a[dig]--;
                }
            }
            else {

                if(isdupl) {
                    ret += func(s,i+1,(tight&&(ub==dig)),true,zapp,ct+1) ;
                }
                else {
                    a[dig]++ ;
                    int temp = func(s,i+1,(tight&&(ub==dig)),((a[dig]>1)||isdupl),zapp,ct+1) ;
                    ret += temp ;
                    a[dig]--;
                }
            }
        } 
        return rs[i][tight][isdupl][zapp][ct] = ret ;
    }
}

int countSpecialNumbers(int n) {
    int i , j;
    memset(a,0,sizeof(a)) ;
    memset(rs,-1,sizeof(rs)) ;
    string s = to_string(n) ;
    return func(s,0,1,0,1,0) ;
}

int main() {
    cout<<countSpecialNumbers(110)<<endl;
}