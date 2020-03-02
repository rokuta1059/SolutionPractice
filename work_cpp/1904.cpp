#include <iostream>
using namespace std;
int arr[1000001];
int find(int t) {
    arr[1] = 1;
    arr[2] = 2;
    if (t<=2) {
        return arr[t];
    } else {
        for(int i=3;i<=t;i++) {
            arr[i]=(arr[i-1]+arr[i-2])%15746;
        } return arr[t];
    }
}
int main() {
    int N;
    cin >> N;
    cout << find(N);
}