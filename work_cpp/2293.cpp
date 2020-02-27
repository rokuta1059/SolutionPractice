#include <iostream>

using namespace std;

int n,k;
int coin[101];
int dpar[10001];

int main() {

    std::cin >> n >> k;

    for(int i = 1; i <= n; i++) {
        cin >> coin[i];
    } 

    dpar[0] = 1;

    // n-1번째까지의 동전을 써서 k원을 만드는 경우의 수 + 
    // n번째까지의 동전을 써서 k-D(n)원을 만드는 경우의 수
    for (int i = 1; i <= n; i++) {
        for(int j = coin[i]; j <= k; j++) {
            dpar[j] += dpar[j - coin[i]];
        }
    }

    std::cout << dpar[k];

    return 0;

}