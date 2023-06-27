t = int(input())

for p in range(1,t+1):
    n, k = map(int,input().split())
    arr = list(map(int,input().split()))
    arr.sort(reverse=True)

    sum = 0
    for i in range(k):
        sum += arr[i]

    print(f'#{p} {sum}')
