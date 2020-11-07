import sys
input = sys.stdin.readline

if __name__ == "__main__":

    # 집합 개념으로 접근
    listen = set()
    see = set()
    N, M = map(int, input().split(' '))
    for _ in range(N):
        listen.add(input().rstrip())
    for _ in range(M):
        see.add(input().rstrip())

    # 듣도보도 못한 사람 = 듣도 못한 사람과 보도 못한 사람의 합집합
    K = listen & see
    print(len(K))

    # 사전 순으로 정렬 후 출력
    for i in sorted(K):
        print(i)
