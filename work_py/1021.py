from sys import stdin
from collections import deque
N, M = map(int, stdin.readline().split())
t = list(map(int, stdin.readline().rstrip().split(' ')))
q = deque([i for i in range(1, N+1)])
count = 0
for i in range(M):
    a = t[i]
    b = q.index(a)
    c = len(q)
    if b < c-b:
        while(a != q[0]):
            q.append(q.popleft())
            count += 1
        q.popleft()
    else:
        while(a != q[0]):
            q.appendleft(q.pop())
            count += 1
        q.popleft()
print(count)