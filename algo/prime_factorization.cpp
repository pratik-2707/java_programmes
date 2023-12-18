#include <bits/stdc++.h>
using namespace std;

vector<int> factor(int n) {
	vector<int> ret;
	for (int i = 2; i * i <= n; i++) {
		while (n % i == 0) {
			ret.push_back(i);
			n /= i;
		}
	}
	if (n > 1) { ret.push_back(n); }
	return ret;
}

int main() {
    int n = 10 ;

    vector <int> v ;
    v = factor(n) ;
    for(auto jj:v) {
        cout<<jj<<" " ;
    }
    cout<<endl;
}

