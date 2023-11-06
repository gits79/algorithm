import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
k = int(input())
arr = []

for _ in range(n):
    arr.append(int(input()))

visited = [False] * (n+1)
selected = [0] * k
result = set()


def recur(cur):
    if cur == k:
        temp = ""
        for i in selected:
            temp += str(i)
        result.add(temp)
        return
    for i in range(n):
        if visited[i]:
            continue
        selected[cur] = arr[i]
        visited[i] = True
        recur(cur + 1)
        visited[i] = False


recur(0)
print(len(result))