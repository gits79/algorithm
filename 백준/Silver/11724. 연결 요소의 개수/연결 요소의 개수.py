import sys
input = lambda : sys.stdin.readline().strip()

n, m = map(int, input().split())
adjList = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
answer = set()
temp = []

for i in range(m):
    a, b = map(int, input().split())
    adjList[a].append(b)
    adjList[b].append(a)

def dfs(v):
    visited[v] = True
    temp.append(v)

    for i in adjList[v]:
        if not visited[i]:
            dfs(i)


for i in range(1, n + 1):
    visited = [False] * (n + 1)
    temp.clear()
    dfs(i)
    temp.sort()
    answer.add(''.join(map(str, temp)))

print(len(answer))