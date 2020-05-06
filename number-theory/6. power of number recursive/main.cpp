/*
    Author: Deepak kumar pandey
    Topic: to find a^b
*/

#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>

using namespace std;
#define ll long long

//  Time complexity: O(log(b))
ll power(ll a, ll b){
    if (b==1)
    {
        return a;
    }
    if (b % 2 == 0){

        return pow(power(a, b/2), 2);
    }
    else{
        return a * power(a, b-1);
    }
}


int main(int argc, char const *argv[])
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    ll b;
    ll a;
    cin >> a >> b;

    cout << power(a, b) << endl;
    return 0;
}