n = int(input())

arr = []

for _ in range(n):
    arr.append(list(map(int, input().split())))
my_x = arr[0][0]
my_y = arr[0][1]
x = arr[0][0]
y = arr[0][1]
result = []

for i in range(1,len(arr)-1):
    length = 0
    for j in range(n):
        if j == i:
            continue

        temp_x = arr[j][0]
        temp_y = arr[j][1]
        length += abs(temp_x - x) + abs(temp_y - y)
        x = temp_x
        y = temp_y

    result.append(length)
    x = my_x
    y = my_y
print(min(result))
