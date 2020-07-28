from sys import stdin
n = int(stdin.readline())
a = []
for _ in range(n):
    t = int(stdin.readline())
    if t == 0:
        a.pop()
    else:
        a.append(t)
print(sum(a))