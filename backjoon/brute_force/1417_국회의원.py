n = int(input())

arr = []
for _ in range(n):
    arr.append(int(input()))

if n == 1:
    print(0)
else:
    my = arr.pop(0)

    count = 0
    while True:
        if my > max(arr):
            break
        my += 1
        i = arr.index(max(arr))
        arr[i] = max(arr) - 1
        count += 1

    print(count)
