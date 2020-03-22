#include <iostream>
using namespace std;
long long arr[1001][10];
int N;
int main() {
    cin >> N;
    for (int i = 0; i < 10; i++) {
        arr[1][i] = 1;
    }
    for(int i = 2; i <= N; i++) {
        arr[i][0] = arr[i-1][0];
        for(int j = 1; j < 10; j++) {
            arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % 10007;
        }
    }
    int sum = 0;
    for(int i = 0; i < 10; i++) {
        sum += arr[N][i];
    }
    cout << sum % 10007;
}