import sys
input = lambda : sys.stdin.readline().strip()

t = int(input())






for tc in range(t):
    n, m = map(int, input().split())
    visited = [False] * (m + 1)
    selected = [0] * n
    global count
    count = 0


    def recur(cur, start):
        global count
        if cur == n:
            # print(*selected)
            count += 1
            return

        for i in range(start, m + 1):
            if visited[i]:
                continue
            selected[cur] = i
            recur(cur + 1, i + 1)
            visited[i] = False


    recur(0, 1)
    print(count)




