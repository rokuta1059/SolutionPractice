from sys import stdin

n = int(stdin.readline())
board = list(stdin.readline().rstrip())
inboard = [0 for _ in range(n)]
for i in range(n):
    if board[i] == 'B': continue
    elif board[i] == 'O': inboard[i] = 1
    else: inboard[i] = 2
dp = [9999999999 for _ in range(n)]
dp[0] = 0
for i in range(1, n):
    for j in range(i):
        if inboard[i] == ((inboard[j] + 1) % 3):
            dp[i] = min(dp[i], dp[j] + (i - j)**2)
print(dp[-1] if dp[-1] != 9999999999 else -1)