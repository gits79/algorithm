n = int(input())

arr = [i + 1 for i in range(n)]
result = []
while True:
    result.append(arr.pop(0))
    if len(arr) == 0:
        break
    temp = arr.pop(0)
    arr.append(temp)

print(*result)