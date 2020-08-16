from sys import stdin

n = int(stdin.readline())
for _ in range(n):
    a, b = map(int, stdin.readline().split(' '))
    if a % 10 == 0:
        print(10)
    else:
        k = 4 + b % 4
        print(str(a**k)[-1])