import sys
input = lambda: sys.stdin.readline().strip()

t = int(input())

for tc in range(t):
    n, m, k = map(int, input().split())
    arr = [[0 for i in range(m)] for i in range(n)]
    di = [-1, 0, 1, 0]
    dj = [0, 1, 0, -1]
    count = 0

    for _ in range(k):
        a, b = map(int, input().split())
        arr[a][b] = 1


    def dfs(arr, i, j):
        arr[i][j] = 0

        for k in range(4):
            ni = i + di[k]
            nj = j + dj[k]
            if (0 <= ni < n) and (0 <= nj < m) and arr[ni][nj] == 1:
                dfs(arr, ni, nj)


    for i in range(n):
        for j in range(m):
            if arr[i][j] == 1:
                count += 1
                dfs(arr, i, j)

    print(count)
