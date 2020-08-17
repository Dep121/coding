#include <bits/stdc++.h>
using namespace std;

int count_triplets(auto v){
    // sort the vector
    sort(v.begin(), v.end());
    int v_size = v.size();
    int p = v.size() - 2;
    int ans = 0;

    for (int i = v_size - 1; i >= 2; --i)
    {
        int start = 0;
        int end = i-1;
        while(start < end){
            if (v[end] + v[start] == v[i]) {
                ans++;
                break;
            } else if (v[start] + v[end] < v[i]){
                start++;
            } else {
                end--;
            }
        }
    }
    return ans;
}

int main(){

    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    int size;
    cin >> size;
    vector<int> v(size, 0);

    for(int i=0; i<size; ++i){
        cin >> v[i];
    }

    int result = count_triplets(v);

    cout << result << endl;
    return 0;
}