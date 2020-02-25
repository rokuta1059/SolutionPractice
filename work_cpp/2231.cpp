#include <iostream>

using namespace std;

int main() {

    int n;
    int digit = 0;

    std::cin >> n;
    int tmp = n;

    while (tmp) {
        tmp = tmp / 10;
        digit++;
    }

    int level = n - (digit * 9);
    for(level; level < n; level++) {
        int sum = level;
        int local = level;
        for(int i = 0; i < digit; i++) {
            sum = sum + (local % 10);
            local = local / 10;
        }
        if (n == sum) {
            cout << level << "\n";
            break;
        }
            
    }
    if (level >= n)
        cout << "0" << "\n";

    return 0;
}