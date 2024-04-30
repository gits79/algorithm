import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())
mp, mf, ms, mv = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

answer = []
global pay
pay = 10000
visited = [False] * n


def recur(cur):
    global pay
    if cur == n:
        charge = 0
        p, f, s, v = 0, 0, 0, 0

        for i in range(n):
            if visited[i]:
                p += arr[i][0]
                f += arr[i][1]
                s += arr[i][2]
                v += arr[i][3]
                charge += arr[i][4]

        if p >= mp and f >= mf and s >= ms and v >= mv:

            temp = []
            for i in range(n):
                if visited[i]:
                    temp.append(i + 1)
            temp.insert(0, charge)
            answer.append(temp)


        return

    visited[cur] = True
    recur(cur + 1)
    visited[cur] = False
    recur(cur + 1)


recur(0)
answer.sort()

if answer:
    print(answer[0][0])
    print(*answer[0][1:])
else:
    print(-1)
