#include <bits/stdc++.h>
using namespace std;


void mergeTwoArrays(vector<int> v1, vector<int> v2, vector<int>& v3){
    int p1=0, p2=0;

    for (int i = 0; i < v3.size(); ++i)
    {
        if (v1[p1] > v2[p2]) {
            v3[i] = v2[p2];
            p2++;
        } else if (v1[p1] < v2[p2]){
            v3[i] = v1[p1];
            p1++;
        } else {
            v3[i] = v1[p1];
            i++;
            v3[i] = v2[p2];
            p1++;
            p2++;
        }

        if (p1 == v1.size()){
            while(p2 != v2.size()){
                i++;
                v3[i] = v2[p2];
                p2++;
            }
            break;
        }

        if (p2 == v2.size())
        {
            while(p1 != v1.size()){
                i++;
                v3[i] = v1[p1];
                p1++;
            }
            break;
        }
    }
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    int size1, size2;
    cin >> size1;
    cin >> size2;

    vector<int> v1(size1, 0);
    vector<int> v2(size2, 0);
    vector<int> v3(size1 + size2, 0);

    for (int i = 0; i < size1; ++i)
    {
        cin >> v1[i];
    }

    for (int i = 0; i < size2; ++i)
    {
        cin >> v2[i];
    }

    mergeTwoArrays(v1, v2, v3);

    for(auto ele: v3){
        cout << ele << " ";
    }
    return 0;
}