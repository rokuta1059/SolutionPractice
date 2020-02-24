#include <stdio.h>
#include <stdlib.h>

#define MAX(X, Y) (X > Y ? X : Y)

int main(void)
{

    // N = 세로, M = 가로, T = 이동 최대 높이, D = 제한 시간
    int N, M, T, D;
    int INF = 10000000;

    int dx[4] = {1, -1, 0, 0};
    int dy[4] = {0, 0, 1, -1};

    char map[26][26];
    int route[680][680];

    scanf("%d%d%d%d", &N, &M, &T, &D);

    for (int n = 0; n < N; n++)
        scanf("%s", map[n]);

    for (int n = 0; n < N; n++)
    {
        for (int m = 0; m < M; m++)
        {
            if (map[n][m] >= 'a' && map[n][m] <= 'z')
            {
                map[n][m] = map[n][m] - 'a' + 26;
            }
            else
            {
                map[n][m] = map[n][m] - 'A';
            }
        }
    }

    for (int n = 0; n < N * M; n++)
        for (int m = 0; m < N * M; m++)
            route[n][m] = n == m ? 0 : INF;

    for (int n = 0; n < N; n++)
    {
        for (int m = 0; m < M; m++)
        {

            int now = n * M + m;
            for (int i = 0; i < 4; i++)
            {

                // 가로가 x, 세로가 y이므로
                // 가로는 m, 세로는 n이다
                int x = m + dx[i];
                int y = n + dy[i];

                // 범위에서 벗어날 경우 건너뛰기
                if (x < 0 || x >= M || y < 0 || y >= N)
                    continue;

                int next = y * M + x;
                int diff = map[n][m] - map[y][x];

                if (abs(diff) <= T)
                {

                    if (diff < 0)
                        route[now][next] = diff * diff;
                    else
                        route[now][next] = 1;
                }
            }
        }
    }

    int MAX_LEN = N * M;
    for (int k = 0; k < MAX_LEN; k++)
    {
        for (int n = 0; n < MAX_LEN; n++)
        {
            for (int m = 0; m < MAX_LEN; m++)
            {
                if (route[n][k] + route[k][m] < route[n][m])
                    route[n][m] = route[n][k] + route[k][m];
            }
        }
    }

    int answer = 0;
    for (int n = 0; n < MAX_LEN; n++)
    {
        if (route[n][0] + route[0][n] <= D)
        {
            answer = MAX(answer, map[n / M][n % M]);
        }
    }

    printf("%d\n", answer);

    return 0;
}