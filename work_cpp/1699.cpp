#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    int N;
    int table[100001];
    cin >> N;
    for(int i = 0; i <= N; i++) {
        table[i] = i;
    }
    for(int i = 2; i <= N; i++) {
        for (int j = 2; j*j <= i; j++) {
            table[i] = min(table[i], table[i - (j * j)] + 1);
        }
    }
    cout << table[N];
}