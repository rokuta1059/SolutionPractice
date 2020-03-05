#include <iostream>
using namespace std;
long pinary[91];
int N;
int main() {
    cin >> N;
    pinary[1] = 1;
    pinary[2] = 1;
    for(int i = 3; i <= N; i++) {
        pinary[i] = pinary[i-1] + pinary[i-2];
    }
    cout << pinary[N];
}