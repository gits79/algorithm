import sys
input = lambda: sys.stdin.readline().strip()


n, m = map(int, input().split())

visited = [False] * (n + 1)
selected = [0] * m

def recur(cur):
    if cur == m:
        print(*selected)
        return

    for i in range(1, n + 1):
        selected[cur] = i
        recur(cur + 1)


recur(0)
