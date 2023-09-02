n = int(input())

selected = [0] * n
visited = [False] * n
arr = []


def recur(cur):
    if cur == n:
        print(*selected)
        return
    for i in range(n):
        if visited[i]:
            continue
        selected[cur] = i + 1
        visited[i] = True
        recur(cur + 1)
        visited[i] = False
recur(0)