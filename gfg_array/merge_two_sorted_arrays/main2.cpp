#include <bits/stdc++.h>
using namespace std;

void swap(int& x1, int& x2){
    int temp = x1;
        x1 = x2;
        x2 = temp;
}

void sort_multiple_sorted_arrays_inplace(vector<int>& v1, vector<int>& v2){
    int s1 = v1.size();
    int s2 = v2.size();

    int t = s1 + s2;

    // two pointers p1 and p2
    for (int gap = t/2; gap >= 1; gap/=2)
    {
        for (int p1 = 0, p2 = gap; p2 < t ; p1++, p2++)
        {
            if (p1 < s1 && p2 < s1)
            {
                if(v1[p1] > v1[p2]){
                    swap(v1[p1], v1[p2]);
                }
            }
            else if (p1 < s1 && p2 >= s1 && p2 < t)
            {
                if(v1[p1] > v2[p2 - s1]){
                    swap(v1[p1], v2[p2 - s1]);
                }
            }
            else if (p1 >= s1 && p1 < t && p2 < t)
            {
                if(v2[p1 - s1] > v2[p2 - s1]){
                    swap(v2[p1 - s1], v2[p2 - s1]);
                }
            }
        }
    }
}

void print(vector<int> v){
    for (auto ele: v)
    {
        cout << ele << " ";
    }
    cout << endl;
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    int s1, s2;
    cin >> s1 >> s2;

    vector<int> v1(s1, 0);
    vector<int> v2(s2, 0);

    for (int i = 0; i < v1.size(); ++i)
    {
        cin >> v1[i];
    }
    for (int i = 0; i < v2.size(); ++i)
    {
        cin >> v2[i];
    }

    sort_multiple_sorted_arrays_inplace(v1, v2);

    print(v1);
    print(v2);
    return 0;
}