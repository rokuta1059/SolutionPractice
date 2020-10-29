def makeAnagram(a, b):
    from collections import Counter
    # Counter는 문자열에서 문자의 수를 계산하여 Dict 형태로 반환한다
    a = Counter(a)
    b = Counter(b)

    # a와 b 각각의 차집합을 구한 후 이를 더한다
    notBinA = a - b
    notAinB = b - a
    notAandB = notAinB + notBinA

    # 구해진 차집합의 수를 반환한다
    return len(list(notAandB.elements()))