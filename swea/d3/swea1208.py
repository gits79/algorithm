
for p in range(1,11):

    n = int(input())
    arr = list(map(int, input().split()))

    for i in range(n):
        max1 = max(arr)
        min1 = min(arr)

        maxI = arr.index(max1)
        minI = arr.index(min1)

        arr[maxI] -= 1
        arr[minI] += 1

        if max(arr) == min(arr):
            max_score = 1
    max_score = max(arr) - min(arr)
    print(f'#{p} {max_score}')
