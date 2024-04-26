import sys
input = lambda: sys.stdin.readline().strip()


k = int(input())
arr = list(map(str, input().split()))


visited = [False] * (10)
selected = [0] * (k + 1)
answer = []
def check(equal, lst):

    for i in range(1, len(lst)):
        if equal[i - 1] == "<":
            if lst[i -1] > lst[i]:
                return False
        else:
            if lst[i - 1] < lst[i]:
                return False
    return True


def recur(cur):
    if cur == k + 1:
        if check(arr, selected):
            # print(*selected)
            temp = ""
            for j in selected:
                temp += str(j)
            answer.append(int(temp))
        return

    for i in range(10):
        if visited[i]: continue
        selected[cur] = i
        visited[i] = True
        recur(cur + 1)
        visited[i] = False


recur(0)
print(max(answer))
if len(str(min(answer))) < k + 1:
    print("0"+str(min(answer)))
else:
    print(min(answer))
