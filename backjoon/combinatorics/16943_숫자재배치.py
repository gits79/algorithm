import sys
input = lambda: sys.stdin.readline().strip()

a, b = map(int, input().split())
a = list(map(int, str(a)))

visited = [False] * (len(a) + 1)
selected = [0] * len(a)
global answer
answer = -1


def recur(cur):
    global answer
    if cur == len(a):
        if selected[0] != 0:
            temp = ''.join(map(str, selected))
            temp = int(temp)
            if temp < b:
                answer = max(answer, temp)
            return

    for i in range(len(a)):
        if visited[i]:
            continue
        visited[i] = True
        selected[cur] = a[i]
        recur(cur + 1)
        visited[i] = False


recur(0)
print(answer)
