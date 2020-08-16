from sys import stdin

n, m = map(int, stdin.readline().split())
cost = list(map(int, stdin.readline().split()))

sum = 0
for i in range(m):
    sum += cost[i]

tmp = sum
for i in range(m, n):
    tmp = tmp + cost[i] - cost[i-m]
    sum = max(sum, tmp)
print(sum)