from sys import stdin
t = int(stdin.readline())
for _ in range(t):
    N, M = map(int, stdin.readline().split(' '))
    ans = 1
    if N != M:
        for i in range(M-N+1, M):
            ans *= i
        for i in range(1, N+1):
            ans //= i

    print(ans)