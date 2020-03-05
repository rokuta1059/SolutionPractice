#include <iostream>
#include <algorithm>
using namespace std;
int arr[100001];
int dp[100001];
int N;
int maximum;
int main() {
    cin >> N;
    for(int i = 1; i <= N; i++) {
        cin >> arr[i];
    }
    dp[1] = arr[1];
    maximum = arr[1];
    for(int i = 2; i <= N; i++) {
        dp[i] = max(arr[i], dp[i-1] + arr[i]);
        maximum = max(dp[i], maximum);
    }
    
    cout << maximum;
}