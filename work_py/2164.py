from sys import stdin
from collections import deque

n = int(stdin.readline())
card = deque([i for i in range(n+1)])
card.popleft()
while(len(card) > 1):
    card.popleft()
    card.append(card.popleft())
print(card[0])