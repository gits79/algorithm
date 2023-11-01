import sys
input = lambda : sys.stdin.readline().strip()

arr = list(map(str, input()))
n = len(arr)
visited = [False] * (n + 1)
selected = [0] * n
result = []

def recur(cur):
    if cur == n:
        temp = ''.join(selected)
        if temp == temp[::-1]:
            result.append(temp)
        return

    for i in range(n):
        if visited[i]:
            continue
        visited[i] = True
        selected[cur] = arr[i]
        recur(cur + 1)
        visited[i] = False


recur(0)
result.sort()

if len(result) == 0:
    print("I'm Sorry Hansoo")
else:
    print(result[0])