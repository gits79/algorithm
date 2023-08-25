t = int(input())

for p in range(1,t+1):
    n = int(input())
    d = [[1] for i in range(n+1)]

    for i in range(2,n+1):
        sum = 0
        for j in range(len(d[i-1])-1):
            sum += d[i-1][j] + d[i-1][j+1]
            d[i].append(sum)
            sum = 0
        d[i].append(1)

    print(f'#{p}')
    for i in range(1,len(d)):
        print(*d[i])

