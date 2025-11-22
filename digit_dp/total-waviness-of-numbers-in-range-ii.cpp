#define ll long long

#include <bits/stdlib.h>
#include <string>
using namespace std ;

class Solution {
    string s ;

    pair<ll,ll> rs[20][10][3][2][2] ;

    pair<ll,ll> func(ll i,ll last_dig,ll comp,ll tight,ll zst,ll n) {
        if(i==n) {
            return {0,1};
        }
        else if(rs[i][last_dig][comp][tight][zst].first!=-1) {
            return rs[i][last_dig][comp][tight][zst] ;
        }
        ll ub = (tight)?(s[i]-'0'):9  , ret=0 , ct =0 ;

        for(ll j=0;j<=ub;j++) {
            if(i==0 || (zst==0)) {
                pair<ll,ll> p = func(i+1,j,0,(tight && (ub==j)),(zst || (j!=0)),n) ;
                ret += p.first ;
                ct += p.second  ;
            }
            else {
                if(comp==1) {
                    ll to_send_comp = (j>last_dig)?2:((j<last_dig)?1:0);
                    pair<ll,ll> p = func(i+1,j,to_send_comp,(tight && (ub==j)),1,n) ;
                    ret += p.first + (((last_dig<j)?1:0)*(p.second)) ;
                    ct += p.second  ;
                }
                else if(comp==2) {
                    ll to_send_comp = (j>last_dig)?2:((j<last_dig)?1:0);
                    pair<ll,ll> p = func(i+1,j,to_send_comp,(tight && (ub==j)),1,n) ;
                    ret += p.first + (((last_dig>j)?1:0)*(p.second)) ;
                    ct += p.second  ;
                }
                else {
                    ll to_send_comp = (j>last_dig)?2:((j<last_dig)?1:0);
                    pair<ll,ll> p = func(i+1,j,to_send_comp,(tight && (ub==j)),1,n) ;
                    ret += p.first ;
                    ct += p.second  ;
                }
            }
        }
        return rs[i][last_dig][comp][tight][zst] =  {ret,ct} ;
    }
    
public:
    long long totalWaviness(long long num1, long long num2) {
        s = to_string(num1-(ll)1) ;
        memset(rs,-1,sizeof(rs)) ;
        ll ret1 = func(0,0,0,1,0,s.length()).first ;
        s = to_string(num2) ;
        memset(rs,-1,sizeof(rs)) ;
        ll ret2 = func(0,0,0,1,0,s.length()).first ;
        cout<<ret1<<" "<<ret2<<endl;
        return (ret2-ret1);
    }
};