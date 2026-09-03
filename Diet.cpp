#include <iostream>
#include <vector>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    long long int n,m,k;cin>>n>>m>>k;
    vector<long long int> val(n);
    vector<bool> diff(n, false);
    long long int curr=0;
    for(long long int i=0;i<n;i++) cin>>val[i];
    for(long long int i=0;i<n;i++){
        if(i>=m && diff[i-m] == true) curr-=val[i-m];
        if(curr+val[i] <= k){
            curr+=val[i];cout<<"Yes\n";
            diff[i] = true;
        } else {
            cout<<"No\n";
        }
    }

}