#include <iostream>
#include <algorithm>
using namespace std;
int arr[1001][3];
int N;
void find() {
    for(int i = 2; i <= N; i++) {
        arr[i][0] += min(arr[i-1][1], arr[i-1][2]);
        arr[i][1] += min(arr[i-1][0], arr[i-1][2]);
        arr[i][2] += min(arr[i-1][0], arr[i-1][1]);
    }
}
int main() {
    cin >> N;
    for(int i = 1; i <= N; i++) {
        cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
    }
    find();
    int tmp = min(arr[N][0], arr[N][1]);
    tmp = min(tmp, arr[N][2]);
    cout << tmp;
}