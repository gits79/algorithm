t = int(input())

for p in range(1,t+1):

    arr = []
    n = int(input())
    result = []

    for _ in range(100):
        arr.append(input())

    count = 0
    # 가로
    for i in range(100):
        for j in range(100-i+1):
            temp = arr[i][j:j+i]
            if temp == temp[::-1]:
                result.append(len(temp))


    # 세로
    # for i in range(100):
    #     for j in range(101):
    #         palindrome = ""
    #         for k in range(j):
    #             palindrome += arr[k][i]
    #             # print(palindrome)
    #         if palindrome[:] == palindrome[::-1]:
    #             result.append(len(palindrome))
    #
    print(f'#{p} {max(result)}')
# print(f'#{p + 1} {count}')
