def rotLeft(a, d):
    from collections import deque
    a = deque(a)
    if len(a) // 2 < d:
        for i in range(len(a) - d):
            a.appendleft(a.pop())
    else:
        for i in range(d):
            a.append(a.popleft())
    return a