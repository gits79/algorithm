a, b, n, w = map(int, input().split())


answer = -1
count = 0
x = 0
y = 0

for i in range(1,1001):
    temp_x = i
    temp_y = n - i

    if i > n-1:
        break

    if a * temp_x + b * temp_y == w:
        count += 1
        x = temp_x
        y = temp_y

if count == 1:
    print(x, y)
else:
    print(answer)

