#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int N;
int cou;
int stik[100001][2];
int dp[100001][2];
int find() {
    if(N == 1) {
        return max(stik[0][0], stik[0][1]);
    }
    dp[1][0] = stik[1][0];
    dp[1][1] = stik[1][1];
    for(int i = 2; i <= N; i++) {
        dp[i][0] = stik[i][0] + max(dp[i-1][1], dp[i-2][1]);
        dp[i][1] = stik[i][1] + max(dp[i-1][0], dp[i-2][0]);
    }
    return max(dp[N][0], dp[N][1]);
}

int main() {
    cin >> cou;
    while(cou-- > 0) {
        memset(stik, 0, sizeof(stik));
        memset(dp, 0, sizeof(dp));
        cin >> N;
        for(int j = 1; j <= N; j++) {
            cin >> stik[j][0];
        }
        for(int j = 1; j <= N; j++) {
            cin >> stik[j][1];
        }
        cout << find() << endl;
    }
}