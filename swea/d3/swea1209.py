t = 10

for p in range(1,t+1):
    n = int(input())
    arr = []
    result = []
    #입력을 받으며 가로 합 계산
    for _ in range(100):
        temp = list(map(int,input().split()))
        arr.append(temp)
        result.append(sum(temp))


    sum_cross1 = 0
    for i in range(100):
        sum_colum = 0
        for j in range(100):
            # 세로합
            sum_colum += arr[j][i]
            # 왼쪽 아래 대각선
            if i==j:
                sum_cross1 += arr[i][j]
        result.append(sum_colum)
    # 오른쪽 아래 대각선
    sum_cross2 = 0
    for i in range(100):
        sum_cross2 += arr[i][99-j]
    result.append(sum_cross2)
    print(f'#{p} {max(result)}')