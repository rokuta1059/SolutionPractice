from collections import deque
from sys import stdin
N, M = map(int, stdin.readline().split())
maze = []
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
stage = [[0]*M for _ in range(N)] # 탐색 여부를 확인하는 배열
search = deque()
count = 0       # 그림의 개수
maximum = 0     # 그림의 최대 크기
for _ in range(N):
    maze.append(list(map(int, stdin.readline().rstrip().split(' '))))
for i in range(N):
    for j in range(M):
        # 그림이 색칠되어 있고 탐색하지 않은 위치인 경우
        # Queue에 추가한 후 탐색 진행
        if maze[i][j] == 1 and stage[i][j] == 0:
            search.append([i, j])
            stage[i][j] = 1
            count += 1
            length = 1  # 현재 그림의 크기
            # Queue에 아무것도 없을 때 까지 탐색 진행
            while(search):
                now = search.popleft()
                for k in range(4):
                    nx = now[0] + dx[k]
                    ny = now[1] + dy[k]
                    # 배열의 크기를 벗어난 경우
                    if nx < 0 or nx >= N or ny < 0 or ny >= M:
                        continue
                    # 색칠된 곳이 아니거나 이미 탐색한 경우
                    if maze[nx][ny] == 0 or stage[nx][ny] > 0:
                        continue
                    length += 1
                    stage[nx][ny] = length
                    # 다음 탐색할 곳 Queue에 저장
                    search.append([nx, ny])
            # 현재 그림과 기존 그림의 크기 비교 후 저장
            maximum = max(length, maximum)
print(count)
print(maximum)