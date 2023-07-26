n = int(input())

arr = []

for _ in range(n):
    arr.append(list(map(int, input().split())))

arr.sort()
result = []
for i in range(n):
    pos = arr[i][0]
    color = arr[i][1]
    left_right = []
    # 오른쪽
    for j in range(i+1,n):
        temp_p = arr[j][0]
        temp_c = arr[j][1]
        if color == temp_c:

            left_right.append(abs(pos - temp_p))
            break
    # 왼쪽
    for j in range(i-1,-1,-1):
        temp_p = arr[j][0]
        temp_c = arr[j][1]
        if color == temp_c:

            left_right.append(abs(pos - temp_p))
            break
    result.append(min(left_right))

print(sum(result))