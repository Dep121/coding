/*
    Author: Deepak kumar pandey
*/

#include <bits/stdc++.h>
using namespace std;

int find_number_of_sub_array_sum_equal_to_sum(auto ar, auto sum){
    int ans = 0;
    int curSum = 0;
    unordered_map<int, int> accu_sum;
    
    for(auto x: ar){
        curSum += x;
        if(curSum == sum){
            ans++;
        }

        if(accu_sum.find(curSum - sum) != accu_sum.end())
            ans += accu_sum[curSum - sum];

        accu_sum[curSum]++;
    }
    return ans;
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    int size, sum;
    cin >> size;
    cin >> sum;
    vector<int> ar(size, 0);
    
    for(int i=0; i<size; ++i){
        cin >> ar[i];
    }

    int result = find_number_of_sub_array_sum_equal_to_sum(ar, sum);

    cout << result << endl;

    // for(auto x: ar){
    //     cout << x << " ";
    // }
    return 0;
}
