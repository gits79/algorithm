t = int(input())

for p in range(1,t+1):

    n = int(input())
    arr = []

    for _ in range(n):
        temp = list(input())
        arr.append(temp)

    # 가로 중간 (농작물 수확 범위 기준)
    mid = n // 2
    # 세로 중간 ( 피봇 이후로 농작물 수확 갯수 줄어듬)
    pivot = n // 2
    sum = 0

    for i in range(n):
        if i <= mid:
            # i = 0, 1, 2   mid 기준으로 i 만큼 수확 범위 증가
            for j in range(mid-i,mid+i+1):
                sum += int(arr[i][j])
        else:
            # pivot = 2, 1, 0    세로 중간 이후 수확 범위 mid 기준 pivot - 1 만큼
            for j in range(mid-(pivot-1),mid+(pivot-1)+1):
                sum += int(arr[i][j])
            pivot -= 1

    print(f'#{p} {sum}')