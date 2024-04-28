import sys
input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

selected = [0] * m
def recur(cur):
    if cur == m:
        print(*selected)
        return

    for i in range(n):
        selected[cur] = arr[i]
        recur(cur + 1)

recur(0)