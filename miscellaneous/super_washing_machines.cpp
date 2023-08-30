#include <bits/stdc++.h>
using namespace std ;

int findMinMoves(vector<int>& m) {
    int sum = 0, n = m.size(),ans=0;
    for(auto &i: m)sum += i;
    if(sum%n)return -1;
    sum /= n;
    int k = 0;
    for(auto &i: m){
        k += i-sum;
        ans = max({(i-sum),ans,abs(k)});
    }
    return ans;
}

int main() {
    vector<int> v = {1,2,3} ;
    cout<<findMinMoves(v)<<endl;
}
