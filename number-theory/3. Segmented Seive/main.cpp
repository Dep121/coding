/*
    Author: Deepak kumar pandey
*/

#include <bits/stdc++.h>
using namespace std;

#define ll long long
//  Time complexity O(root(n)loglogn)
//  check prime numbers upto n

//odd number optimization
bool optimizePrimeSeive(int* p, int n){
    p[0] = p[1] = 0;   //  0, 1 is not prime
    p[2] = 1;
    //   let assume all odd numbers upto n are prime
    //   mark it as 1
    for (int i = 3; i <= n; i+=2)
    {
        p[i] = 1;
    }

    //  mark the numbers who are not prime
    for (int i = 3; i * i <= n; i+=2)
    //  before root(n), all the numbers can mark "the numbers upto n" who are not prime.
    {
        if(!p[i]) continue;
        for (int j = i * i; j < n; j+=i)
    //  we can start with i*i because all the numbers before i*i are already marked by numbers less than i.
        {
            p[j] = 0;
        }
    }
 return 0;
}

void segmentedSeive(ll a, ll b){
    int p[1000000] = {0};
    ll n = (ll)ceil(sqrt(b));
    //  find the prime numbers from 2 to root(b) i.e. n;
    optimizePrimeSeive(p, n);

    bool sp[b-a+1];
    //assume all the numbers are prime from a to b;
    memset(sp, true, (b-a+1) * sizeof(bool));

    //  loop 2 to root(b) and check for every prime number if it divides any number from a to b;
    for (int i = 2; i <= n; ++i)
    {
        if(p[i]){
            for (ll j = a; j <= b; ++j)
            {
                if (j % i == 0)
                {
                    sp[j-a] = false; //if number is divisible then mark it as non-prime (false)
                }
            }
        }
    }

//  print the prime numbers from a to b;
    for (ll i = a; i <= b; ++i)
    {
        if (sp[i - a])
        {
            cout << i << " ";
        }
    }
}

int main(int argc, char const *argv[])
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    ll a, b, n;
    cin >> a >> b;

    segmentedSeive(a, b);
    return 0;
}
