def solution(s):
    a = len(s)
    if a == 1:
        return 1
    length = []
    for i in range(1, a // 2 + 1):
        counter = 1
        tmp = s[:i]
        l = ''
        for j in range(i, a+1, i):
            if s[j:i+j] == tmp:
                counter += 1
            else: 
                if counter == 1:
                    l = l + tmp
                else:
                    l = l + str(counter) + tmp
                counter = 1
                tmp = s[j:i+j]
        if a % i != 0:
            l = l + tmp
        length.append(len(l))
        
    return min(length)