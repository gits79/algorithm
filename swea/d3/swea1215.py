for p in range(10):

    arr = []
    n = int(input())

    for _ in range(8):
        arr.append(input())

    count = 0
    # 가로
    for i in range(8):
        for j in range(8 - n + 1):
            temp = arr[i][j:j + n]
            if temp[:] == temp[::-1]:
                count += 1

    # 세로
    for i in range(8):
        for j in range(8 - n + 1):
            max_score = ""
            for k in range(j,j+n):
                max_score += arr[k][i]
            if max_score[:] == max_score[::-1]:
                count += 1

    print(f'#{p+1} {count}')

