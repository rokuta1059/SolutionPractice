from sys import stdin
n, m = map(int, stdin.readline().split())
xlist = []
ylist = []
sum = 0

def lower_bound(l, value):
    start, end, mid = 0, len(l), len(l)
    while end > start:
        mid = (start + end) // 2
        if l[mid] < value:
            start = mid + 1
        else:
            end = mid
    return end

def upper_bound(l, value):
    start, end, mid = 0, len(l), len(l)
    while end > start:
        mid = (start + end) // 2
        if l[mid] <= value:
            start = mid + 1
        else:
            end = mid
    return end


for _ in range(n):
    x, y = map(int, stdin.readline().split())
    sum += abs(x) + abs(y)
    xlist.append(x)
    ylist.append(y)

xlist.sort()
ylist.sort()
nx = 0
ny = 0

st = stdin.readline().rstrip()
for i in st:
    if i == 'S':
        ny += 1
        count_y = lower_bound(ylist, ny)
        sum += count_y - (len(ylist) - count_y)
    if i == 'J':
        ny -= 1
        count_y = upper_bound(ylist, ny)
        sum += (len(ylist) - count_y) - count_y
    if i == 'I':
        nx += 1
        count_x = lower_bound(xlist, nx)
        sum += count_x - (len(xlist) - count_x)
    if i == 'Z':
        nx -= 1
        count_x = upper_bound(xlist, nx)
        sum += (len(xlist) - count_x) - count_x
    print(sum)

