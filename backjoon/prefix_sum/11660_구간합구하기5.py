import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr = []
arr.append([0] * (n + 1))
for _ in range(n):
    temp = [0] + list(map(int, input().split()))
    arr.append(temp)

prefix_sum = [[0] * (n + 1) for i in range(n + 1)]

# 가로
for i in range(1, n + 1):
    for j in range(1, n + 1):
        prefix_sum[i][j] = prefix_sum[i][j - 1] + arr[i][j]

# 세로
for i in range(1, n + 1):
    for j in range(1, n + 1):
        prefix_sum[j][i] += prefix_sum[j - 1][i]

for i in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    print(prefix_sum[x2][y2] - prefix_sum[x1 - 1][y2] - prefix_sum[x2][y1 - 1] + prefix_sum[x1 - 1][y1 - 1])
