import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
arr = []
result = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

for i in range(n):
    count = 0
    for j in range(n):
        if i == j:
            continue
        if arr[i][0] < arr[j][0] and arr[i][1] < arr[j][1]:
            count += 1
    result.append(count + 1)

print(*result)