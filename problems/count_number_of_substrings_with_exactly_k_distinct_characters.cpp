#include <bits/stdc++.h>

using namespace std ;


class Solution
{
    
long long int func(string s,int k)
    {
        int arr[26]={0};
        long long int count=0;
        int distinct=0;
        int i,left=0;
        for(i=0;i<s.length();i++)
        {
            if(arr[s[i]-'a'] == 0)
                distinct++;
            arr[s[i]-'a']++;
            while(distinct>k)
            {
                arr[s[left]-'a']--;
                if(arr[s[left]-'a'] == 0)
                    distinct--;
                left++;
            }
            count+=i-left+1;
        }
        return count;
    }
    
  public:
    long long int substrCount (string s, int k) {
    	//code here.
    	int i , j ,n = s.length(),ans=0 ,l=0,r=0;
    	return func(s,k) - func(s,k-1) ;
    }
};