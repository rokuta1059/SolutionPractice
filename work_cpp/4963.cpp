#include <iostream>
#include <cstring>
using namespace std;
int dx[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
int dy[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
int N, M;
int map[50][50];
int rou[50][50];

void dfs(int x, int y) {

    for(int a = 0; a < 8; a++) {
        int nx = x + dx[a];
        int ny = y + dy[a];
        if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == 1 && rou[nx][ny] == 0) {
            rou[nx][ny] = 1;
            dfs(nx, ny);
        }
    }
    
}

int main() {

    while(1) {
        cin >> N >> M;
        if(N == 0 && M == 0)
            return 0;

        memset(rou, 0, sizeof(rou));
        
        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                cin >> map[i][j];
            }
        }
        int count = 0;
        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && rou[i][j] == 0) {
                    rou[i][j] = 1;
                    dfs(i,j);
                    count++;
                }
            }
        }
        cout << count << "\n";

    }
    
    
}