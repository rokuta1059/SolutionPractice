from sys import stdin
from collections import deque

n = int(stdin.readline())
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

for _ in range(n):
    M, N, K = map(int, stdin.readline().split(' '))
    maze = [[0]*M for _ in range(N)]
    for _ in range(K):
        x, y = map(int, stdin.readline().split(' '))
        maze[y][x] = 1
    stage = [[0]*M for _ in range(N)]
    search = deque()
    count = 0
    for i in range(N):
        for j in range(M):
            if maze[i][j] == 1 and stage[i][j] == 0:
                search.append([i, j])
                stage[i][j] = 1
                count += 1
                while(search):
                    y, x = map(int, search.pop())
                    for k in range(4):
                        nx = x + dx[k]
                        ny = y + dy[k]
                        if nx < 0 or nx >= M or ny < 0 or ny >= N: continue
                        if maze[ny][nx] == 0 or stage[ny][nx] == 1: continue
                        search.append([ny, nx])
                        stage[ny][nx] = 1
    print(count)