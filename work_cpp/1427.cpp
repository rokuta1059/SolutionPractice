#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int main() {
    string a;
    std::cin >> a;
    sort(a.begin(), a.end(), greater<char>());
    cout << a;
}