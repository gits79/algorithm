import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))
global answer
answer = 0

visited = [False] * n
selected = [0] * n

def recur(cur):
    global answer
    if cur == n:
        pay = 0
        day = [True] * n
        for i in range(n):
            if visited[i] and day[i]:
                work = arr[i]
                if i + work[0] <= n:
                    pay += work[1]
                    for j in range(i, i + work[0]):  # 오류 수정: for 루프 범위 수정
                        day[j] = False
        answer = max(answer, pay)
        return

    visited[cur] = True
    recur(cur + 1)
    visited[cur] = False
    recur(cur + 1)

recur(0)
print(answer)
