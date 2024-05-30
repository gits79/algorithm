import sys
input = lambda: sys.stdin.readline().strip()

a = input()
b = input()

n = len(a)
m = len(b)

count = 0
arr = [False] * n
for i in range(n - m + 1):
    if arr[i]:
        continue
    if a[i:i+m] == b:
        count += 1
        for j in range(i, i + m):
            arr[j] = True

print(count)