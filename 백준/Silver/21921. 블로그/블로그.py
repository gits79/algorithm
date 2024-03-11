import sys
input = lambda: sys.stdin.readline().strip()

n, k = map(int, input().split())
arr = [0] + list(map(int, input().split()))

prefix = [0] * (n + 1)

for i in range(1, n + 1):
    prefix[i] = arr[i] + prefix[i - 1]

result = []

for i in range(k, n + 1):
    result.append(prefix[i] - prefix[i - k])

answer = max(result)

if answer == 0:
    print("SAD")
else:
    print(answer)
    print(result.count(answer))
