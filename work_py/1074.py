from sys import stdin

def zet(x, y, k):
    if k == 0:
        return 0
    half = 2 ** (k-1)
    if x < half and y < half: return zet(x, y, k-1)
    if x < half and y >= half: return half * half + zet(x, y-half, k-1)
    if x >= half and y < half: return 2 * half * half + zet(x-half, y, k-1)
    return 3 * half * half + zet(x-half, y-half, k-1)

n, r, c = map(int, stdin.readline().split(' '))
print(zet(r, c, n))
