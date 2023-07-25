n, k, a, b = map(int,input().split())

arr = [k for i in range(n)]

count = 0
while min(arr) > 0:
    min_i = arr.index(min(arr))
    if min_i < a - 1:
        for i in range(a):
            arr[min_i + i] += b
    elif min_i > len(arr) - 1:
        for i in range(a):
            arr[min_i - i] += b
    else:
        min_l = 101
        min_r = 101
        for i in range(1,a):
            if arr[min_i + i] < min_r:
                min_r = arr[min_i + i]
            if arr[min_i - i] < min_l:
                min_r = arr[min_i - i]

        if min_r < min_l:
            for i in range(a):
                arr[min_i + i] += b
        else:
            for i in range(a):
                arr[min_i - i] += b

    count += 1
    for i in range(n):
        arr[i] -= 1


print(count)