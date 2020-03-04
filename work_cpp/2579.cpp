#include <iostream>
#include <algorithm>
using namespace std;
int route[301];
int stair[301];
int N;
int main() {
    cin >> N;
    for(int i = 1; i <= N; i++) {
        cin >> stair[i];
    }
    route[1] = stair[1];
    route[2] = stair[1] + stair[2];
    for (int i = 3; i <= N; i++) {
        route[i] = max(route[i-3] + stair[i-1] + stair[i], route[i-2] + stair[i]);
    }
    cout << route[N];
}