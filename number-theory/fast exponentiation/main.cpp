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
ll fastExpo(ll a, ll b){

    ll res = 1;
    while(b){
        if(b & 1){
            res = res * a;
        }
        a = a * a;
        b = b >> 1;
    }
    return res;
}

/*
    ##  fastExpo

    a = 3
    b = 6 = 110

    1                   1                   0
    3 ^ 4             3 ^ 2              3 ^ 1
        2^2               2^1                2^0    ----> exponention
    1 * (3^4)     *     1 * (3^2)     *     0 * (3^1)  = 3^6

*/

//  Time complexity: O(log(b))
ll fastExpoMod(ll a, ll b, ll m){

    ll res = 1;
    while(b){
        if(b & 1){
            res = (res * a) % m;
        }
        a = (a * a) % m;
        b = b >> 1;
    }
    return res;
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

    cout << fastExpo(a, b) << endl;
    return 0;
}