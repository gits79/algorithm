n, k = map(int, input().split())

arr = [i for i in range(2, n + 1)]
result = []

while len(arr) != 0:
    p = arr.pop(0)
    result.append(p)

    if len(arr) > 0:
        temp = []
        for i in range(len(arr)):
            if arr[i] % p == 0:
                temp.append(arr[i])
                result.append(arr[i])
        for i in temp:
            arr.remove(i)

print(result[k - 1])
