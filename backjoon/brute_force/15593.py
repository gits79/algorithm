n = int(input())
arr = []

# def counting(arr):
#     result = []
#     count = 0
#     going = 0
#     for i in arr:
#         if i == 1 and going == 0:
#             going = 1
#             count += 1
#         elif i == 1 and going == 1:
#             count += 1
#         elif i == 0 and going == 1:
#             result.append(count)
#             going = 0
#             count = 0
#     result.append(count)
#     return max(result)


for _ in range(n):
    arr.append(list(map(int, input().split())))

farm = []
result = []
for _ in range(1001):
    farm.append(0)

# 해고전 커버
for i in arr:
    for j in range(i[0], i[1]):
        farm[j] += 1

for i in arr:
    farm2 = farm.copy()
    count = 0
    for j in range(i[0], i[1]):
        farm2[j] -= 1

    for k in farm2:
        if k > 0:
            count += 1
    result.append(count)
print(max(result))
