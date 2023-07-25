n = int(input())

arr = [0 for i in range(1001)]
max_x = 0
max_y = 0
max_height = 0
for _ in range(n):
    x, y = map(int, input().split())
    arr[x] = y
    if x > max_x:
        max_x = x
    if y > max_y:
        max_y = y
        max_height = x

height = 0
area = 0

for i in range(1, max_height + 1):
    if arr[i] > height:
        height = arr[i]
        area += height
    else:
        area += height


# 가운데 기준 오른쪽 반대로 뒤집기
height = 0
for i in range(1000, max_height, -1):
    if arr[i] > height:
        height = arr[i]
        area += height
    else:
        area += height


print(area)
