n = int(input())
arr = []

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
    # 한명씩 해고
    for j in range(i[0], i[1]):
        farm2[j] -= 1

    # 범위 계산
    for k in farm2:
        if k > 0:
            count += 1
    result.append(count)

print(max(result))
