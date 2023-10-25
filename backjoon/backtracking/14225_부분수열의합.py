import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))
visited = [False] * (n + 1)
num = [0] * 2_000_003


def recur(cur):

    if cur == n:
        summ = 0
        for i in range(n):
            if visited[i]:
                summ += arr[i]
        num[summ] = 1
        return

    visited[cur] = False
    recur(cur + 1)
    visited[cur] = True
    recur(cur + 1)


recur(0)

for i in range(1,2_000_001):
    if num[i] == 0:
        print(i)
        break


