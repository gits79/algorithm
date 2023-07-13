t = int(input())

for p in range(1, t + 1):

    n = int(input())
    temp_arr = list(map(int, input().split()))
    arr = []

    for i in temp_arr:
        if i < 0:
            arr.append(-1 * i)
        else:
            arr.append(i)
    arr.sort()

    result = arr[0]
    count = arr.count(result)

    print(f'#{p} {result} {count}')
