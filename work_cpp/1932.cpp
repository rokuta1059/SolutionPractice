#include <iostream>
#include <algorithm>
using namespace std;
int tri[500][500];
int N;
int maximum;
int main() {
    cin >> N;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j <= i; j++) {
            cin >> tri[i][j];
        }
    }
    for(int i = 1; i < N; i++) {
        for(int j = 0; j <= i; j++) {
            if(j == 0) {
                tri[i][j] += tri[i-1][j];
            } else if (j == i) {
                tri[i][j] += tri[i-1][j-1];
            } else {
                tri[i][j] += max(tri[i-1][j-1], tri[i-1][j]);
            }
        }
    }
    maximum = 0;
    for(int i = 0; i < N; i++) {
        maximum = max(tri[N-1][i], maximum);
    }
    cout << maximum;
}