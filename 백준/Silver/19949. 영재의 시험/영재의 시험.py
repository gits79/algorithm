import sys
input = lambda : sys.stdin.readline().strip()

answer = list(map(int, input().split()))
selected = []
result = 0


def recur(cur):
    global result
    if cur == 10:
        count = 0
        for i in range(10):
            if answer[i] == selected[i]:
                count += 1
        if count >= 5:
            result += 1
        return

    for i in range(1, 6):
        if cur > 1 and selected[-1:-3:-1] == [i, i]:
            continue
        selected.append(i)
        recur(cur + 1)
        selected.pop()


recur(0)
print(result)

