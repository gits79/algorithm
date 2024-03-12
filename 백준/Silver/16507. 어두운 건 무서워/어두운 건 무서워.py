import sys
input = lambda: sys.stdin.readline().strip()

n, m, k = map(int, input().split())

arr = [[0] * (m + 1)]
for _ in range(n):
    arr.append([0] + list(map(int, input().split())))

prefix = [[0] * (m + 1) for i in range(n+1)]


for i in range(1, n + 1):
    for j in range(1, m + 1):
        prefix[i][j] = arr[i][j] + prefix[i][j - 1]

for i in range(1, m + 1):
    for j in range(1, n + 1):
        prefix[j][i] += prefix[j - 1][i]



for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    area = prefix[x2][y2] - prefix[x1 -1][y2] - prefix[x2][y1-1] + prefix[x1 -1][y1 - 1]
    avg = (x2 - x1 + 1) * (y2 - y1 + 1)
    print(area // avg)