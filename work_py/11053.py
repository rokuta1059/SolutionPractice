import sys
input = sys.stdin.readline

def findArr(n, ar):
    dp = [0] * n

    for i in range(n):
        dp[i] = 1
        for j in range(i):
            if ar[j] < ar[i] and dp[i] < dp[j] + 1:
                dp[i] = dp[j] + 1

    return max(dp)


if __name__ == "__main__":
    N = int(input())
    arr = list(map(int, input().split(' ')))
    print(findArr(N, arr))