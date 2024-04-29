import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))

global answer
answer = 0
selected = [0] * n
visited = [False] * n
def recur(cur):
    global answer
    if cur == n:
        temp = 0
        for i in range(n - 1):
            temp += abs(selected[i] - selected[i + 1])
        answer = max(answer, temp)
        return

    for i in range(n):
        if visited[i]:
            continue
        visited[i] = True
        selected[cur] = arr[i]
        recur(cur + 1)
        visited[i] = False

recur(0)
print(answer)
