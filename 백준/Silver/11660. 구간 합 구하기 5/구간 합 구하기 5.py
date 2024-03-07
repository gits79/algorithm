import sys
input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())
arr = []
arr.append([0] * (n+1))
for _ in range(n):
    arr.append([0] + list(map(int, input().split())))

prefix = [[0] * (n + 1) for i in range(n+1)]

for i in range(1,n+1):
    for j in range(1 , n + 1):
        prefix[i][j] = prefix[i][j - 1] + arr[i][j]


for i in range(1, n+1):
    for j in range(1, n+1):
        prefix[j][i] = prefix[j - 1][i] + prefix[j][i]


for i in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    print(prefix[x2][y2] - prefix[x1 -1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1] )