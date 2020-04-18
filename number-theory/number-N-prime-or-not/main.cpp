/*
	Author: Deepak kumar pandey
*/

#include <bits/stdc++.h>
using namespace std;

//  Time complexity O(root(n))
bool checkPrime(int n){
	if (n<=2)	return false;

    if (n % 2 == 0)    return false;

    //odd numbers
    for (int i = 3; i * i <= n; i+=2)
    {
        if (n % i == 0)
        {
            return false;
        }
    }
 return true;
}

int main(int argc, char const *argv[])
{
	#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
	#endif

	int n;
	cin >> n;

	cout << checkPrime(n) << endl;

	return 0;
}
