import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))
lst = list(map(int, input().split()))
visited = lst.copy()
selected = [0] * (n - 1)

def cal(n, a, b):
    if n == 0:
        return a + b
    elif n == 1:
        return a - b
    elif n == 2:
        return a * b
    else:
        if a < 0:
            return a * -1 // b * -1
        else:
            return a // b
answer = []
def recur(cur):
    if cur == n - 1:
        a = arr.copy()
        for i in range(n - 1):
            temp = cal(selected[i], a[i], a[i + 1])
            a[i + 1] = temp
        answer.append(a[-1])
        return

    for i in range(4):
        if visited[i] == 0:
            continue
        visited[i] -= 1
        selected[cur] = i
        recur(cur + 1)
        visited[i] += 1


recur(0)
print(max(answer))
print(min(answer))