import sys
input = sys.stdin.readline

def find(Y, X, red, gre, blu):
    # 휴리스틱 기반 풀이
    # 인접한 색 기준으로 판단하기
    result = 0
    for y in range(Y - 1):
        for x in range(X - 1):
            result += abs(red[y + 1][x] - red[y][x])
            result += abs(red[y][x + 1] - red[y][x])
            result += abs(gre[y + 1][x] - gre[y][x])
            result += abs(gre[y][x + 1] - gre[y][x])
            result += abs(blu[y + 1][x] - blu[y][x])
            result += abs(blu[y][x + 1] - blu[y][x])

    # 테스트케이스 확인 결과 1과 2가 유사한 값이 나온다
    # 이부분을 세세하게 다루면...
    result /= Y * X * 2
    if result < 9: return 4
    if result < 23: return 1
    if result < 54: return 2
    return 3

if __name__ == "__main__":

    H, W = map(int, input().split(' '))
    R = [None for _ in range(H)]
    G = [None for _ in range(H)]
    B = [None for _ in range(H)]
    for i in range(H):
        R[i] = list(map(int, input().rstrip().split(' ')))
    for i in range(H):
        G[i] = list(map(int, input().rstrip().split(' ')))
    for i in range(H):
        B[i] = list(map(int, input().rstrip().split(' ')))
    print(find(H, W, R, G, B))
