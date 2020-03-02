#include <iostream>
using namespace std;
long long arr[101];
void find() {
    arr[1] = 1;
    arr[2] = 1;
    arr[3] = 1;
    arr[4] = 2;
    arr[5] = 2;
    for(int i=6;i<=100;i++) {
        arr[i]=arr[i-5]+arr[i-1];
    }  
}

int main() {
    int N;
    cin >> N;
    find();
    for (int i = 0; i < N; i++) {
        int tmp;
        cin >> tmp;
        cout << arr[tmp] << "\n";
    }
}