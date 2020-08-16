from sys import stdin

a = int(stdin.readline())
b = int(stdin.readline())
c = int(stdin.readline())

if a == 60 and b == 60 and c == 60:
    print('Equilateral')
elif a + b + c == 180:
    if a == b or a == c or b == c:
        print('Isosceles')
    else:
        print('Scalene')
else:
    print('Error')