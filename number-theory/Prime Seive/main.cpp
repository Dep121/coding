/*
    Author: Deepak kumar pandey
*/

#include <bits/stdc++.h>
using namespace std;

//  Time complexity O(root(n))
//  check prime numbers upto n
bool primeSeive(int* p, int n){
    p[0] = p[1] = 0;   //  0, 1 is not prime

    //   let assume all numbers upto n are prime
    //   mark it as 1
    for (int i = 2; i <= n; i++)
    {
        p[i] = 1;
    }

    //  mark the numbers who are not prime
    for (int i = 2; i * i <= n; ++i)
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

int main(int argc, char const *argv[])
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    int n;
    cin >> n;

    int p[1000000] = {0};
    primeSeive(p, n);
    //optimizePrimeSeive(p, n);
    for (int i = 0; i <= n; ++i)
    {
        if(p[i])
            cout << i << ", ";
    }
    return 0;
}
