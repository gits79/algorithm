import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
x, y = map(int, input().split())
m = int(input())
adjList = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
global count
count = 0
answer = []

for _ in range(m):
    a, b = map(int, input().split())
    adjList[a].append(b)
    adjList[b].append(a)



def dfs(v):
    global count
    visited[v] = True
    count += 1

    if v == x:
        answer.append(count - 1)

    for i in adjList[v]:
        if not visited[i]:
            dfs(i)
            count -= 1


dfs(y)
if answer:
    print(answer[-1])
else:
    print(-1)