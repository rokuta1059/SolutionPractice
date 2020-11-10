import sys
input = sys.stdin.readline

if __name__ == "__main__":
    password = dict()
    N, M = map(int, input().split(' '))
    for _ in range(N):
        site, pw = map(str, input().rstrip().split(' '))
        password[site] = pw
    for _ in range(M):
        print(password[input().rstrip()])