import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

visited = [False] * n
selected = [0] * n
global answer
answer = 1_000_000_001

def recur(cur):
    global answer
    if cur == n:
        count = 0
        a = 1
        b = 0
        for i in range(n):
            if visited[i]:
                count += 1
                a *= arr[i][0]
                b += arr[i][1]
        if count > 0:
            answer = min(answer, abs(a - b))
        return

    visited[cur] = True
    recur(cur + 1)
    visited[cur] = False
    recur(cur + 1)


recur(0)
print(answer)
