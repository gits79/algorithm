import sys
input = lambda : sys.stdin.readline().strip()

n, m, v = map(int, input().split())
arr = []
answer = []
adjList = [[] for i in range(m+1)]
global visited
visited = [False] * (m + 1)
for _ in range(m):
    a, b = map(int, input().split())
    adjList[a].append(b)
    adjList[b].append(a)
# print(adjList)
for i in adjList:
    i = i.sort()
# print(adjList)

def dfs(cur):
    global visited
    visited[cur] = True
    print(cur, end=" ")

    for i in adjList[cur]:
        if not visited[i]:
            dfs(i)


def bfs(start):
    queue = []

    queue.append(start)
    visited[start] = True
    print(start, end=" ")

    while queue:
        current = queue.pop(0)

        for i in adjList[current]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                print(i, end=" ")

dfs(v)
visited = [False] * (m + 1)
print()
bfs(v)


