import sys
input = sys.stdin.readline

if __name__ == "__main__":
    target = int(input())
    n = int(input())
    btn = {i for i in range(0, 10)}
    btn -= set(map(int, input().split(' '))) if n else set()

    min_cnt = abs(100 - target)
    for i in range(1000001):
        t = str(i)
        for j in range(len(t)):
            # 누를 수 없는 버튼이면 break
            if int(t[j]) not in btn:
                break
            # 모두 누를 수 있는 버튼이면
            # 해당 위치에서 목적지로 가는것이 더 빠른지
            # 기존 값이 더 빠른지 계산
            elif j == len(t) - 1:
                min_cnt = min(min_cnt, abs(target - i) + len(t))
    print(min_cnt)