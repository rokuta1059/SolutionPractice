import sys
input = sys.stdin.readline

if __name__ == "__main__":

    # 이름과 번호 dict를 따로 두고 호출한다
    # 시간 복잡도를 최소화
    dict_num = dict()
    dict_name = dict()

    N, M = map(int, input().split(' '))
    for i in range(N):
        a = input().rstrip()
        dict_num[i] = a
        dict_name[a] = i

    for i in range(M):
        t = input().rstrip()
        if t.isdigit():
            print(dict_num[int(t) - 1])
        else:
            print(dict_name[t] + 1)