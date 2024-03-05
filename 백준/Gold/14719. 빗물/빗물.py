import sys
input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())
arr = [0] + list(map(int, input().split()))

prefix = [0] * (m + 2)
suffix = [0] * (m + 2)

for i in range(1, m + 1):
    prefix[i] = max(arr[i], prefix[i - 1])

for i in range(m, 0, -1):
    suffix[i] = max(arr[i], suffix[i + 1])

answer = 0
for i in range(1, m + 1):
    answer += min(prefix[i], suffix[i]) - arr[i]

print(answer)
