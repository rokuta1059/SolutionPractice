#include <iostream>
using namespace std;

long long fi[91];

long long fibo(int x) {

    fi[0] = 0;
    fi[1] = 1;

    for (int i = 2; i <= x; i++) {
        fi[i] = fi[i-1] + fi[i-2];
    }
    
    return fi[x];
}

int main() {
    int a;
    std::cin >> a;
    std::cout << fibo(a);
}