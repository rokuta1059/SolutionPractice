import sys
input = sys.stdin.readline

def bitonic(n, ar):
    dp = [0] * n        # 증가하는 부분 수열을 구하는 배열
    rev_dp = [0] * n    # 감소하는 부분 수열을 구하는 배열

    # 증가하는 부분 수열 구하기
    for i in range(n):
        dp[i] = 1
        for j in range(i):
            if ar[j] < ar[i] and dp[i] < dp[j] + 1:
                dp[i] = dp[j] + 1

    # 감소하는 부분 수열 구하기
    for i in range(n - 1, -1, -1):
        rev_dp[i] = 1
        for j in range(n - 1, i - 1, -1):
            if ar[j] < ar[i] and rev_dp[i] < rev_dp[j] + 1:
                rev_dp[i] = rev_dp[j] + 1

    # 가장 큰 값 찾기
    ans = 0
    for i in range(n):
        # 중복된 값을 제거하기 위해 -1을 해준다
        tmp = dp[i] + rev_dp[i] - 1
        if ans < tmp:
            ans = tmp
    return ans


if __name__ == "__main__":
    N = int(input())
    arr  = list(map(int, input().split(' ')))
    print(bitonic(N, arr))