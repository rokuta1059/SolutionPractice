import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

def dfs(y, x):
    if y == 0 and x == 0:
        return 1
    if dp[y][x] != -1:
        return dp[y][x]

    dp[y][x] = 0

    for dy, dx in dxdy:
        ny = y + dy
        nx = x + dx

        if ny < 0 or ny >= N or nx < 0 or nx >= M:
            continue
        if maps[ny][nx] > maps[y][x]:
            dp[y][x] += dfs(ny, nx)

    return dp[y][x]

if __name__ == "__main__":
    N, M = map(int, input().split(' '))
    maps = [list(map(int, input().split(' '))) for _ in range(N)]
    dp = [[-1] * M for _ in range(N)]
    dxdy = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    print(dfs(N - 1, M - 1))