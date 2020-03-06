#include <iostream>
#include <algorithm>
using namespace std;
int N;
int maximum;
int time[16];
int cost[16];
int dp[16];
int main() {
    cin >> N;
    for(int i = 1; i <= N; i++) {
        cin >> time[i] >> cost[i];
    }
    for(int i = 1; i <= N; i++) {
        if(i + time[i] <= N+1) {
            dp[i + time[i]] = max(dp[i + time[i]], dp[i] + cost[i]);
            maximum = max(maximum, dp[i + time[i]]);
        }
        dp[i + 1] = max(dp[i], dp[i + 1]);
        maximum = max(dp[i], dp[i + 1]);
    }
    cout << maximum;
}