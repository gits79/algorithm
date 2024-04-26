import sys
input = lambda: sys.stdin.readline().strip()


n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

visited = [False] * (n)
selected = [0] * m

def recur(cur):
    if cur == m:
        print(*selected)
        return

    for i in range(n):
        if visited[i]: continue
        selected[cur] = arr[i]
        visited[i] = True
        recur(cur + 1)
        visited[i] = False


recur(0)
