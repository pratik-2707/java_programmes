#include<bits/stdc++.h>
using namespace std;

class Solution {
    
    int rs[505][505] ; 
    
public:
    int solve(vector<int>& cost, vector<int>& time, int i, int currCost, int busy, int taken){

        int n = cost.size();

        if(busy >= (n- taken)){
            return 0;
        }

        if(i >= n){
            if(busy < (n-taken))
                return INT_MAX;
            
            return 0;
        }
        
        if(rs[i][taken+busy]!=-1){
            return rs[i][taken+busy];
        }

        return rs[i][taken+busy] = min((long long )solve(cost,time,i+1,currCost + cost[i],busy + time[i],taken+1)+cost[i],(long long )solve(cost,time,i+1,currCost,busy,taken));

    }

    int paintWalls(vector<int>& cost, vector<int>& time) {
        
        memset(rs,-1,sizeof(rs)) ;

        return solve(cost,time,0,0,0,0);
    }
};