/*
    Author: Deepak kumar pandey
*/

#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>

using namespace std;
#define ll long long

//  time complexity O(log(max(a, b)))
ll gcd(ll a, ll b){
    if (b == 0)
    {
        return a;
    }

    return gcd(b, a % b);
}

int reduceNumberSize(string a, ll b){
    int mod = 0;
    for (int i = 0; i < a.length(); ++i)
    {
        mod = (mod * 10 + a[i] - '0') % b;
    }

    return mod % b;
}

ll largeGCD(string a, ll b){
    ll num = reduceNumberSize(a, b);

    return gcd(num, b);
}

int main(int argc, char const *argv[])
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    ll b;
    string a;
    cin >> a >> b;

    cout << largeGCD(a, b) << endl;
    return 0;
}