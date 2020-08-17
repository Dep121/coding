/*
    Author: Deepak kumar pandey
    Topic: Try writing a program to compute the 4 right-most digits of 2 ^ 10105 + 2 ^ 123456. Your output should be 3968.
*/

#include <bits/stdc++.h>

using namespace std;

int last4Digit(int base1, int exp1, int base2, int exp2){
    int ans1 = 1, ans2 = 1;
    for (int i = 0; i < exp1; ++i)
    {
        ans1 = (ans1 * base1) % 10000;
    }

    for (int i = 0; i < exp2; ++i)
    {
        ans2 = (ans2 * base2) % 10000;
    }

    return (ans1 + ans2) % 10000;
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    int base1, exp1, base2, exp2;
    cin >> base1 >> exp1;
    cin >> base2 >> exp2;
    cout << last4Digit(base1, exp1, base2, exp2);

    return 0;
}