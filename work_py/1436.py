t = input()
a = 666
for i in range(int(t)):
    while(not '666' in str(a)):
        a = a + 1
    a = a + 1
print("{}".format(a - 1))