import sys
input = sys.stdin.readline

def candies(n, arr):
    dp = [1 for _ in range(n)]
    for i in range(n - 1):
        if arr[i + 1] > arr[i]:
            dp[i + 1] = dp[i] + 1
    for j in range(n - 1, 0, -1):
        if arr[j - 1] > arr[j] and dp[j - 1] <= dp[j]:
            dp[j - 1] = dp[j] + 1
    return sum(dp)

if __name__ == "__main__":
    N = int(input())
    child = []
    for _ in range(N):
        child.append(int(input()))
    print(candies(N, child))