from sys import stdin

def find(x1, y1, r1, x2, y2, r2):
    d2 = (x2 - x1) ** 2 + (y2 - y1) ** 2
    larg = (r2 + r1) ** 2
    sma = (r2 - r1) ** 2
    if d2 == 0: 
        if sma == 0: return -1
        else: return 0
    elif larg == d2 or sma == d2: return 1
    elif larg > d2 and sma < d2: return 2
    else: return 0

n = int(stdin.readline())
for _ in range(n):
    x1, y1, r1, x2, y2, r2 = map(int, stdin.readline().split(' '))
    print(find(x1, y1, r1, x2, y2, r2))
