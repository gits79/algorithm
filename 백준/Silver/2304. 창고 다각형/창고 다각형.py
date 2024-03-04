import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = [0] * 1002

for i in range(n):
    x, y = map(int, input().split())
    arr[x] = y

prefix = [0] * 1002
suffix = [0] * 1002

for i in range(1, 1001):
    prefix[i] = max(arr[i], prefix[i - 1])

for i in range(1000, 0, -1):
    suffix[i] = max(arr[i], suffix[i + 1])

area = 0
for i in range(1, 1001):
    area += min(suffix[i], prefix[i])

print(area)