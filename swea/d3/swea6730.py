t = int(input())


for p in range(1,t+1):
    n = int(input())
    arr = list(map(int,input().split()))

    high = []
    low = []

    for i in range(len(arr)-1):
        if arr[i] - arr[i+1] > 0:
            low.append(arr[i] - arr[i+1])
        else:
            high.append(arr[i] - arr[i + 1])

        high.append(0)
        low.append(0)

    print(f'#{p} {min(high)*-1} {max(low)}')