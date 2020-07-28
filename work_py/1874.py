from sys import stdin
n = int(stdin.readline())
stack = []
ans = []
a = 0
find = True
for _ in range(n):
    t = int(stdin.readline())
    if stack and t == stack[-1]:
        stack.pop()
        ans.append('-')
    elif a > t:
        find = False
        break
    else:
        while(a < t):
            a += 1
            ans.append('+')
            stack.append(a)
        stack.pop()
        ans.append('-')
if not find:
    print('NO')
else:
    print('\n'.join(ans))