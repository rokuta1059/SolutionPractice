import sys
input = sys.stdin.readline

def lcs(A, B):
    A = '*' + A
    B = '#' + B
    dp = [[0] * len(B) for _ in range(len(A))]
    for i in range(len(A)):
        for j in range(len(B)):
            if A[i] == B[j]:
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                dp[i][j] = max(dp[i][j-1], dp[i-1][j])
    return dp[-1][-1]

if __name__ == "__main__":
    A = input().rstrip()
    B = input().rstrip()
    print(lcs(A, B))