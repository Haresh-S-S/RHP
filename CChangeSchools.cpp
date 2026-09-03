#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, k;
    if (!(cin >> n >> k))
        return 0;
    vector<int> vec(k + 1, 0);
    for (int i = 0; i < n; i++)
    {
        int cl;
        cin >> cl;
        vec[cl]++;
    }
    int m = *max_element(vec.begin() + 1, vec.end());
    int cnt = 0;
    for (int i = 1; i <= k; i++)
    {
        if (m - vec[i] <= 1)
        {
            cnt++;
        }
    }
    cout << cnt << "\n";
    return 0;
}