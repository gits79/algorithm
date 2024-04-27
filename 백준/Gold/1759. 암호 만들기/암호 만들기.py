import sys
input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())
arr = list(map(str, input().split()))
arr.sort()

selected = [0] * n
answer = []
mo = ["a","e","i","o","u"]
def recur(cur, start):
    if cur == n:
        temp = ''.join(selected)
        count = 0
        for i in selected:
            if i in mo:
                count += 1
        if count >= 1 and len(selected) - count - 2 >= 0:

            print(temp)
        return

    for i in range(start, m):
        selected[cur] = arr[i]
        recur(cur + 1, i + 1)

recur(0, 0)

