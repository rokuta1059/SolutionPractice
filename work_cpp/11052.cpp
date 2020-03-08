#include <iostream>
#include <algorithm>
using namespace std;
int N;
int dp[1001];
int card[1001];
int main() {
    cin >> N;
    for(int i = 1; i <= N; i++) {
        cin >> card[i];
    }
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= i; j++) {
            dp[i] = max(dp[i], dp[i - j] + card[j]);
        }
    }
    cout << dp[N];
}