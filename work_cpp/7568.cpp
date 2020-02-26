#include <iostream>

using namespace std;

int student[50][2];
int level[50];
int N;

int main() {

    std::cin >> N;

    for (int i = 0; i < N; i++) {
        int kg, cm;
        cin >> kg >> cm;
        student[i][0] = kg;
        student[i][1] = cm;
        level[i] = 1;
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (student[i][0] < student[j][0] && student[i][1] < student[j][1]) {
                level[i]++;
            }
        }
    }

    for (int i = 0; i < N - 1; i++) {
        cout << level[i] << " ";
    }
    cout << level[N-1];

}