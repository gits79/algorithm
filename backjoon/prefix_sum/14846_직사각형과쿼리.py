n = int(input())
arr = []
arr.append([0] * (n+1))
for _ in range(n):
    temp = list(map(int, input().split()))
    temp.insert(0, 0)
    temp.insert(n+1, 0)
    arr.append(temp)


prefix_sum = [[0] * (n+1) for i in range(n+1)]


for i in range(1, n+1):
    temp = []
    for j in range(1, n+1):
        if arr[i][j] not in temp:
            temp.append(arr[i][j])
            prefix_sum[i][j] = prefix_sum[i][j-1] + 1
        else:
            prefix_sum[i][j] = prefix_sum[i][j-1]
print(prefix_sum)


print(arr)


q = int(input())
for _ in range(q):
    x1, y1, x2, y2 = map(int, input().split())