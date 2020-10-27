import sys

def luckBalance(k, contests):
    from collections import deque
    onearr = []
    zerarr = []
    for i, j in contests:
        if j:
            onearr.append(i)
        else:
            zerarr.append(i)
    onearr = deque(sorted(onearr, reverse=True))
    getarr = []
    for i in range(k):
        if onearr:
            getarr.append(onearr.popleft())
        else:
            break

    return sum(zerarr) + sum(getarr) - sum(onearr)

if __name__ == '__main__':
    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    contests = []

    for _ in range(n):
        contests.append(list(map(int, input().rstrip().split())))

    result = luckBalance(k, contests)
    print(result)


