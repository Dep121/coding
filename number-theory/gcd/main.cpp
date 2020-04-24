/*
    Author: Deepak kumar pandey
*/

#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>

using namespace std;

//  time complexity O(log(max(a, b)))
int gcd(int a, int b){
    if (b == 0)
    {
        return a;
    }

    return gcd(b, a % b);
}

int main(int argc, char const *argv[])
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    int a, b;
    cin >> a >> b;
    cout << gcd(a, b) << endl;
    return 0;
}