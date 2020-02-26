#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string whiteFirst[8] = {
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW"
};
string blackFirst[8] = {
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB"
};
string board[50];
int N, M;
int minimum = 99999999;

int countWhiteFirst(int x, int y) {
    int count = 0;
    for(int i = 0; i < 8; i++) {
        for(int j = 0; j < 8; j++) {
            if(whiteFirst[i][j] != board[x + i][y + j])
                count++;
        }
    }
    return count;
}

int countBlackFirst(int x, int y) {
    int count = 0;
    for(int i = 0; i < 8; i++) {
        for(int j = 0; j < 8; j++) {
            if(blackFirst[i][j] != board[x + i][y + j])
                count++;
        }
    }
    return count;
}

int main() {

    std::cin >> N >> M;

    for (int i = 0; i < N; i++) {
        cin >> board[i];
    }

    for (int i = 0; i < N - 7; i++) {
        for (int j = 0; j < M - 7; j++) {
            minimum = min(minimum, min(countBlackFirst(i, j), countWhiteFirst(i, j)));
        }
    }

    cout << minimum << endl;
}
