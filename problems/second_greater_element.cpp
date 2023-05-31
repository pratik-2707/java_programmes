#include <bits/stdc++.h>
using namespace std;

#define ll long long int


class Compare
{
public:
    bool operator()(pair<ll,ll> a, pair<ll,ll> b)
    {
        return a.second<b.second;
    }
};


class Solution {
    
    
ll *func(vector<int> a,ll n) {
	ll i, j  ;
	static ll rs[100005] ;
	memset(rs,-1,sizeof(rs)) ;
	vector<ll> v ;
    
	priority_queue<pair<ll,ll>,vector<pair<ll,ll>>,Compare> pq;

	for(i=0;i<n;i++) {
		if(i==0) {
			v.push_back(0) ;
		}
		else {
            
            while(pq.size()>0) {
                ll ind = pq.top().second ;
                
                if(a[ind]<a[i]) {
                    rs[ind] = a[i] ;
                    pq.pop() ;
                }
                else {
                    break;
                }
            }
            
			while(v.size()>0) {
				ll ind = v[v.size()-1] ;
				if(a[ind]<a[i]) {
					pq.push({a[ind],ind}) ;
					v.pop_back() ;
				}
				else {
					break;
				}
			}
			v.push_back(i) ;
		}
	}

	return rs;
} 
    
public:
    vector<int> secondGreaterElement(vector<int>& nums) {
        ll *p = func(nums,nums.size()) ;
        
        vector<int> ans ;
        for(int i=0;i<nums.size();i++) {
            ans.push_back((int)p[i]) ;
        }
        return ans;
    }
};