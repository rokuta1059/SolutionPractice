#include <iostream>
#include <algorithm>
using namespace std;
int route[10001];
int wine[10001];
int N;
int maximum;
int main() {
    cin >> N;
    for(int i = 1; i <= N; i++) {
        cin >> wine[i];
    }
    route[1] = wine[1];
    route[2] = max(wine[1], wine[1] + wine[2]);
    for (int i = 3; i <= N; i++) {
        route[i] = max(route[i-3] + wine[i-1] + wine[i], route[i-2] + wine[i]);
        route[i] = max(route[i], route[i-1]);
    }
    for (int i = 1; i <= N; i++) {
        maximum = max(route[i], maximum);
    }
    cout << maximum;
}