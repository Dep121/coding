#include <bits/stdc++.h>
using namespace std;

int find_a_sub_array_with_given_sum(vector<int> v, int size, int k){
    int si = 0;
    int ei = 0;
    int sum = 0;
    for(int i=0; i<size; ++i){
        sum += v[i];
        while(sum > k && si <= i){
            sum -= v[si];
            si++;
            if(sum == k){
                ei = i;
                break;
            }
        }
        if(sum == k){
            ei = i;
            break;
        }
    }

    for(int i=si; i<=ei; ++i){
        cout << v[i] << " ";
    }

    cout << "(" << si << " to " << ei << ")" << endl;

    return 0;
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    int size, k;
    cin >> size;
    cin >> k;

    vector<int> v(size, 0);

    for (int i = 0; i < size; ++i)
    {
        cin >> v[i];
    }

    find_a_sub_array_with_given_sum(v, size, k);
    return 0;
}
