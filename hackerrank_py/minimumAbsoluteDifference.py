def minimumAbsoluteDifference(arr):
    min = 10 ** 10
    arr = sorted(arr)
    for i in range(len(arr) - 1):
        tmp = abs(arr[i] - arr[i + 1])
        if tmp < min:
            min = tmp
    return min
