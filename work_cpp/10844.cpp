#include <iostream>
using namespace std;
long long arr[101][10];
int N;
int main() {
    cin >> N;
    for(int i = 0; i < 10; i++) {
        if(i == 0) {
            arr[1][i] = 0;
        } else {
            arr[1][i] = 1;
        }
    }
    for(int i = 2; i <= N; i++) {
        for(int j = 0; j < 10; j++) {
            if(j == 0) {
                arr[i][j] = arr[i-1][j+1];
            } else if (j == 9) {
                arr[i][j] = arr[i-1][j-1];
            } else {
                arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % 1000000000;
            }
        }
    }

    long long sum = 0;
    for(int i = 0; i < 10; i++) {
        sum = (sum + arr[N][i]) % 1000000000;
    }
    cout << sum;

}