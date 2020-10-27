def check(a, b):
    return True if a == b or a == b.lower() else False

def abbreviation(a, b):
    a = '#' + a
    b = '#' + b
    dp = [[False]*len(b) for _ in range(len(a))]
    dp[0][0] = True
    for i in range(len(a)):
        for j in range(len(b)):
            if dp[i - 1][j - 1] and check(a[i], b[j]):
                dp[i][j] = True
            if a[i].islower() and dp[i - 1][j]:
                dp[i][j] = True
    return 'YES' if dp[-1][-1] else 'NO'