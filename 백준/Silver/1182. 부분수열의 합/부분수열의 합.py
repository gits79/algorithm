import sys

input = lambda: sys.stdin.readline().strip()

n, s = map(int, input().split())
arr = list(map(int, input().split()))
global count
count = 0

visited = [False] * (n + 1)


def recur(cur):
    global count
    if cur == n:
        result = 0
        for i in range(n):
            if visited[i]:
                result += arr[i]
        if result == s:
            count += 1

        return

    visited[cur] = False
    recur(cur + 1)
    visited[cur] = True
    recur(cur + 1)


recur(0)

if s == 0:
    print(count - 1)
else:
    print(count)
