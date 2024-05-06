import sys
input = lambda: sys.stdin.readline().strip()

n, m, v = map(int, input().split())
adjlist = [[] for i in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    adjlist[a].append(b)
    adjlist[b].append(a)

for i in range(n + 1):
    adjlist[i].sort()


def dfs(cur):

    visited[cur] = True
    print(cur, end=" ")

    for i in adjlist[cur]:
        if not visited[i]:
            dfs(i)

def bfs(start):
    visited = [False] * (n + 1)
    queue = []
    queue.append(start)
    visited[start] = True
    print(start, end=" ")

    while queue:
        current = queue.pop(0)

        for i in adjlist[current]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                print(i, end=" ")

dfs(v)
print()
bfs(v)