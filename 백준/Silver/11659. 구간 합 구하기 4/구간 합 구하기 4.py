import sys
input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())
arr = [0] + list(map(int, input().split()))

prefix = [0] * (n + 2)

for i in range(1, n + 1):
    prefix[i] = arr[i] + prefix[i - 1]


for i in range(m):
    a, b = map(int, input().split())
    print(prefix[b] - prefix[a-1])
