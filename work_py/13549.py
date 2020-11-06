import sys
from collections import deque
input = sys.stdin.readline

deq = deque()
time = [-1] * 100001

# 1697번 문제와 거의 동일한 문제
# BFS로 풀이
def bfs(N, K):
    time[N] = 0
    deq.append([N, 0])
    while deq:
        location, t = deq.popleft()
        # 동생을 잡은 경우 해당 위치 반환
        if location == K:
            return t
        # 해당 위치가 한 번 다녀온 위치이면서
        # 이전보다 더 시간이 오래 걸린 경우 continue
        if time[location] != -1 and time[location] < t:
            continue
        time[location] = t
        # 곱셈으로 이동하는 경우만 주의
        tmp = [[location * 2, t],
               [location - 1, t + 1],
               [location + 1, t + 1]]
        # 범위 확인 후 저장
        for i in tmp:
            if 0 <= i[0] <= 100000:
                deq.append(i)


if __name__ == "__main__":

    N, K = map(int, input().split(' '))
    print(bfs(N, K))