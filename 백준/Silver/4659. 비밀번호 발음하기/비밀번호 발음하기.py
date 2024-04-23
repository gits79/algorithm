import sys
input = lambda: sys.stdin.readline().strip()


while True:
    s = input()

    if s == "end":
        break

    arr = ["a", "e", "i", "o", "u"]

    result = True

    count1 = 0
    for i in s:
        if i in arr:
            count1 += 1
    if count1 == 0:
        result = False



    count2 = 0
    count3 = 0
    for j in s:
        if j in arr:
            count2 += 1
            count3 = 0

        else:
            count3 += 1
            count2 = 0

        if count2 == 3 or count3 == 3:
            result = False


    flag = False
    for l in range(len(s) - 1):
        if s[l] == s[l + 1] and s[l] != "e" and s[l] != "o":
            result = False

        elif s[l] == s[l + 1] and s[l] == "e" and s[l] == "o":
            if flag == False:
                flag = True
            else:
                result = False

        else:
            flag = False


    if result:
        print(f'<{s}> is acceptable.')
    else:
        print(f'<{s}> is not acceptable.')
