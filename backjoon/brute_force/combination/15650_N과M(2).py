import sys
input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())

selected = [0] * m


def recur(cur, start):
    if cur == m:
        print(*selected)
        return

    for i in range(start, n + 1):
        selected[cur] = i
        recur(cur + 1, i + 1)


recur(0, 1)
