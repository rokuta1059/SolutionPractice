from sys import stdin
while True:
    a = list(map(str, stdin.readline().rstrip()))
    if a[0] == '.': break
    ans = True
    stack = []
    for i in a:
        if i == '(':
            stack.append(i)
        elif i == '[':
            stack.append(i)
        elif i == ')':
            if not stack or stack.pop() != '(':
                ans = False
                break
        elif i == ']':
            if not stack or stack.pop() != '[':
                ans = False
                break
    if stack:
        ans = False
    print('yes' if ans else 'no')