import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = [1,5,10,50]
visited = [False] * (n + 1)
selected = [0] * n
s = set()


def recur(cur, start):
    if cur == n:
        s.add(sum(selected))
        return

    for i in range(start, len(arr)):
        selected[cur] = arr[i]
        recur(cur + 1, i )


recur(0, 0)
print(len(s))
