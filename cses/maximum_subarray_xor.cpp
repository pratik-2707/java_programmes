#include <bits/stdc++.h>
using namespace std ;
#define ll long long int 
#define FASTIO ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
#define mod 1000000007

/* Code  : Pratik Bhagat */

//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

ll nbits = 32 , node_ctr=1;
ll trie[32*200005][2] ;

void insert(ll num) {
    ll node = 0;
    for(ll i=nbits-1;i>=0;i--) {
        ll is_set = (((1<<i)&(num))!=0) ;
        if(trie[node][is_set]==0) {
            trie[node][is_set] = node_ctr++;
        }
        node = trie[node][is_set] ;
    }
}

ll func_query(ll num) {
    ll node = 0 , ret = 0;
    for(ll i=nbits-1;i>=0;i--) {
        ll is_set = (((1<<i)&(num))!=0) ;
        if(trie[node][1^is_set]!=0) {
            ret += (1<<i) ;
            node = trie[node][1^is_set];
        }
        else {
            node = trie[node][is_set] ;
        }
    }
    return ret;
}

int main() {
    FASTIO ; 
    ll t,i,j,k,l,r,mid,n,m,y,z ,x,curr,sum,ind,test,temp, a, b;
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif

    cin>>t;

    while(t--) {
        cin>>n;
        ll maxm_xor = 0 , prefxor = 0 ;

        for(i=0;i<(nbits*n)+5;i++) {
            trie[i][0] = trie[i][1]= 0;
        }
        
        node_ctr = 1;
        insert(0) ;

        for(i=0;i<n;i++) {
            cin>>x ;
            prefxor ^= x ;
            maxm_xor = max(maxm_xor,func_query(prefxor)) ;
            insert(prefxor) ;
        }

        cout<<maxm_xor<<endl;
    }
}

