import math
x, y = map(int, input().split())
my_x = x
my_y = y

arr = []
for _ in range(3):
    arr.append(list(map(int, input().split())))

result = []

# for i in arr:
#     temp_x = i[0]
#     temp_y = i[1]
#     result.append(int(abs(x - temp_x) + abs(y - temp_y)))
#     x = temp_x
#     y = temp_y
#     print(x, y)
#
# print(result)

# for i in range(3):
#     length = 0
#     for j in range(3):
#         if i == j:
#             continue
#         for k in range(3):
#             if k == i or k == j:
#                 continue
#             # print(i,j,k)
#             temp_x = arr[i][0]
#             temp_y = arr[i][1]
#             length += int(abs(x - temp_x) + abs(y - temp_y))
#             x = temp_x
#             y = temp_y
#
#             temp_x = arr[j][0]
#             temp_y = arr[j][1]
#             length += int(abs(x - temp_x) + abs(y - temp_y))
#             x = temp_x
#             y = temp_y
#
#             temp_x = arr[k][0]
#             temp_y = arr[k][1]
#             length += int(abs(x - temp_x) + abs(y - temp_y))
#             x = temp_x
#             y = temp_y
#             print(i+1,j+1,k+1)
#
#             print(length)
#
#         result.append(length)
#         length = 0
#         x = m
#         y = 0
#         print()
# print(min(result))


for i in range(3):
    length = 0
    for j in range(3):
        if i == j:
            continue
        for k in range(3):
            if k == i or k == j:
                continue

            temp_x = arr[i][0]
            temp_y = arr[i][1]
            length += math.sqrt(abs(x - temp_x) ** 2 + abs(y - temp_y) ** 2)
            x = temp_x
            y = temp_y

            temp_x = arr[j][0]
            temp_y = arr[j][1]
            length += math.sqrt(abs(x - temp_x) ** 2 + abs(y - temp_y) ** 2)
            x = temp_x
            y = temp_y

            temp_x = arr[k][0]
            temp_y = arr[k][1]
            length += math.sqrt(abs(x - temp_x) ** 2 + abs(y - temp_y) ** 2)
            x = temp_x
            y = temp_y


        result.append(length)

        length = 0
        x = my_x
        y = my_y

print(int(min(result)))


