import sys
input = lambda: sys.stdin.readline().strip()

a, b, d = map(int, input().split())

arr = [True] * (b + 1)
count = 0
arr[1] = False

for i in range(2, int(b ** 0.5) + 1):
    if arr[i]:
        for j in range(i + i, b + 1, i):
            arr[j] = False

for i in range(a, b + 1):
    if arr[i]:
        if str(d) in str(i):
            count += 1


print(count)

