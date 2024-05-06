import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
m = int(input())
adjList = [[] for i in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    adjList[a].append(b)
    adjList[b].append(a)


visited = [False] * (n + 1)
global count
count = 0

def dfs(cur):
    global count
    visited[cur] = True
    count += 1
    # print(cur, end=" ")

    for i in adjList[cur]:
        if not visited[i]:
            dfs(i)


dfs(1)
print(count - 1)
