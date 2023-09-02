t = int(input())

for _ in range(t):
    n = int(input())
    global count
    count = 0
    selected = [0] * 15
    visited = [False] * 3
    arr = [1, 2, 3]

    def recur(cur):
        if cur == n:
            count += 1
            print(*selected)
            return
        for i in arr:
            if visited[i]:
                continue
            selected[cur] = i + 1
            visited[i] = True
            recur(cur + 1)
            visited[i] = False
    recur(0)