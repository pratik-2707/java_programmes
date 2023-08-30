class Solution {
int mod = 1e9 + 7;
int rs[23][2][405];
int compmax , compmin ;

// https://leetcode.com/problems/count-of-integers/description/?envType=list&envId=relyabt5

int func(string s , int i,bool tight,int sum) {
    if(i==s.length()) {
        return (sum<=compmax && sum>=compmin) ? 1 : 0; 
    }
    else if(rs[i][tight][sum]!=-1) {
        return rs[i][tight][sum]%mod ;
    }
    else {
        int dig , ub , ret=0 ;
        ub = (tight) ? (s[i]-'0') : 9;

        for(dig=0;dig<=ub;dig++) {
            if(sum+dig<=compmax) {
                ret = ((ret%mod) + (func(s,i+1,(tight&&(ub==dig)),sum+dig))% mod)%mod ;
            }
        } 
        return rs[i][tight][sum] = (ret)%mod ;
    }
}

public:
    int count(string num1, string num2, int min_sum, int max_sum) {
        int i , j , sum=0;
        compmax = max_sum ;
        compmin = min_sum ;
        memset(rs,-1,sizeof(rs)) ;
        int t1 = func(num1,0,1,0) ;
        memset(rs,-1,sizeof(rs)) ;
        int t2 = func(num2,0,1,0) ;
        for(i=0;i<num1.length();i++) {
            sum += (num1[i]-'0') ;
        }
        if(sum>=compmin && sum<=compmax) {
            return (((t2%mod)-(t1%mod)+mod)%mod+1)%mod;
        }
        return ((t2%mod)-(t1%mod)+mod)%mod;
    }
};