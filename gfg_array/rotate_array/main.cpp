#include <bits/stdc++.h>
using namespace std;

void rotate_array(vector<int>& v, int r){
    int size = v.size();

    for (int i = 0; i < size; ++i)
    {
        v[(i+r)%size] = v[(i+r)%size] * 10 + v[i];
        v[i] = v[i]%10;
    }
}

void print(vector<int>& v){
    for(auto ele: v){
        cout << ele << " ";
    }
    cout << endl;
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    int size, rotation;
    cin >> size >> rotation;

    vector<int> v(size, 0);

    for(int i=0; i<size; ++i){
        cin >> v[i];
    }

    rotate_array(v, rotation);

    print(v);
    return 0;
}