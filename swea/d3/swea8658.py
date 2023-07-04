t = int(input())

for p in range(1,t+1):
    arr = list(map(int,input().split()))
    result = []
    for i in arr:
        num = str(i)
        sum = 0
        for j in num:
            sum += int(j)
        result.append(sum)
    print(f'#{p} {max(result)} {min(result)}')
