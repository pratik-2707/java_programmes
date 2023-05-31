#include <bits/stdc++.h>
#define ll long long int

// problem link : https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/description/


using namespace std ;


    string func(string s) {
        int i , j ;
        for(i=s.length()-1;i>=0;i--) {
            if(s[i]!='0') {
                s[i] = '0';
                if(i!=0) {
                    s[i-1] = (s[i-1]) + 1 ;
                }
                else {  // this is edge case 
                    // example target is 1 and n is 19 
                    // then we have to add 1 in beginnig  to make it 100
                    s = '1' + s ;
                }
                return s;
            }
        }
        return s;
    }

    ll findsum(string s) {
    	ll sum = 0;
    	for(int i=0;i<s.length();i++) {
    		sum += (s[i]-'0') ;
    	}
    	return sum ;
    }

    ll string_to_int(string s) {
    	ll ret =0 , mu = pow(10,s.length()-1) , i;

    	for(i=0;i<s.length();i++) {
    		ret += ((s[i]-'0')*mu) ;
    		mu /= 10 ;
    	}
    	return ret ;
    }

    long long makeIntegerBeautiful(long long n, int target) {
        string s = to_string(n) ;
        if(s.length()==1 && target<findsum(s)) {
            return 10-n ;
        }  
        ll sum , curr ;
        sum = findsum(s) ;
        while(sum>target) {
            s = func(s) ;
            sum = findsum(s) ;
        }

        return string_to_int(s)-n ;
    }


int main() {
    cout<<makeIntegerBeautiful(366564564,4)<<endl;
}