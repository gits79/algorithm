n, k = map(int, input().split())

visited = [False] * (n + 1)
selected = []
result = []
def recur(cur):

    if sum(selected) > n:
        return

    if sum(selected) == n:
        temp = '+'.join(map(str,selected))
        result.append(temp)
        return

    for i in range(1,4):
        selected.append(i)
        recur(cur + 1)
        selected.pop()


recur(0)
if len(result) > k - 1:
    print(result[k-1])
else:
    print(-1)