t = int(input())

for p in range(1,t+1):
    arr = []
    n, m = map(int,input().split())
    for _ in range(n):
        arr.append(list(map(int,input().split())))

    result = []
    count = 0
    
    # n-m+1 인덱스 범위 내 최대 탐색 횟수
    for i in range(n-m+1):
        for j in range(n-m+1):
            sum = 0
            for k in range(m):
                for l in range(m):
                    sum += arr[i+k][j+l]
            result.append(sum)

    print(f'#{p} {max(result)}')