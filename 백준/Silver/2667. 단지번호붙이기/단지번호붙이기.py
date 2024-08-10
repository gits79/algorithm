import sys
input = lambda: sys.stdin.readline().strip()

di = [-1, 0, 1, 0]
dj = [0, 1, 0, -1]


def dfs(arr, i, j):
    global count
    size = len(arr[0])
    arr[i][j] = 0

    for d in range(4):
        ni = i + di[d]
        nj = j + dj[d]
        if ni >= 0 and ni < size and nj >= 0 and nj < size and arr[ni][nj] == 1:
            count += 1
            dfs(arr, ni, nj)


n = int(input())
answer = []
arr = []
for _ in range(n):
    temp = input()
    temp = list(map(int, temp))
    arr.append(temp)

for i in range(n):
    for j in range(n):
        if arr[i][j] == 1:
            count = 1
            dfs(arr, i, j)
            answer.append(count)

print(len(answer))
answer.sort()
for i in answer:
    print(i)
