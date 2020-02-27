#include <iostream>

using namespace std;

int room[50][50];
int tmproom[50][50];
int R;
int C;
int T;
int air1, air2;

void resetRoom() {
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            tmproom[i][j] = 0;
        }
    }
}

void copyRoom() {

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            room[i][j] = tmproom[i][j];
        }
    }
    room[air1][0] = -1;
    room[air2][0] = -1;

}

void rotation() {

    // 상단 - 왼쪽
    for (int i = air1; i > 0; i--) {
        tmproom[i][0] = tmproom[i-1][0];
    }
    tmproom[air1][0] = 0;
    // 상단 - 위쪽
    for (int i = 1; i < C; i++) {
        tmproom[0][i-1] = tmproom[0][i];
    }
    // 상단 - 오른쪽
    for (int i = 0; i < air1; i++) {
        tmproom[i][C-1] = tmproom[i+1][C-1];
    }
    // 상단 - 아래쪽
    for (int i = C-1; i > 0; i--) {
        tmproom[air1][i] = tmproom[air1][i-1];
    }

    // 하단 - 왼쪽
    for (int i = air2; i < R-1; i++) {
        tmproom[i][0] = tmproom[i+1][0];
    }
    tmproom[air2][0] = 0;
    // 하단 - 아래쪽
    for (int i = 1; i < C; i++) {
        tmproom[R-1][i-1] = tmproom[R-1][i];
    }
    // 하단 - 오른쪽
    for (int i = R-1; i >= air2; i--) {
        tmproom[i][C-1] = tmproom[i-1][C-1];
    }
    // 하단 - 위쪽
    for (int i = C-1; i > 0; i--) {
        tmproom[air2][i] = tmproom[air2][i-1];
    }
    
}

void setDust() {
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (room[i][j] > 0) {
                if(room[i][j] < 5) {
                    tmproom[i][j] += room[i][j];
                    continue;
                }
                int dust = room[i][j] / 5;
                int count = 0;
                // 위
                if(i-1 >= 0) {
                    if(room[i-1][j] != -1) {
                        tmproom[i-1][j] += dust;
                        count++;
                    }
                }
                // 아래
                if(i+1 < R) {
                    if(room[i+1][j] != -1) {
                        tmproom[i+1][j] += dust;
                        count++;
                    }
                }
                // 왼쪽
                if(j-1 >= 0) {
                    if (room[i][j-1] != -1) {
                        tmproom[i][j-1] += dust;
                        count++;
                    }
                }
                // 오른쪽
                if(j+1 < C) {
                    if (room[i][j+1] != -1) {
                        tmproom[i][j+1] += dust;
                        count++;
                    }
                }
                tmproom[i][j] += (room[i][j] - dust * count);
            }
        }
    }
}


int main() {

    std::cin >> R >> C >> T;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> room[i][j], tmproom[i][j];
        }
    }

    for (int i = 0; i < R; i++) {
        if (room[i][0] == -1) {
            air1 = i;
            air2 = i + 1;
            break;
        }
    }

    for (int i = 0; i < T; i++) {
        resetRoom();
        setDust();
        rotation();
        copyRoom();
    }
    
    int ans = 0;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            ans += room[i][j];
        }
    }

    ans += 2;
    cout << ans << endl;

    return 0;
}