def maxSubsetSum(arr):
    dp = [0 for _ in range(len(arr))]
    dp[0] = arr[0] if arr[0] > 0 else 0
    dp[1] = arr[1] if arr[1] > 0 else arr[0]
    for i in range(2, len(dp)):
        dp[i] = max(dp[i-1], dp[i-2]) if arr[i] < 0 else max(dp[i-1], dp[i-2] + arr[i])

    return dp[-1]