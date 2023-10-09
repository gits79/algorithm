import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = []
for _ in range(n):
    arr.append(input())

count = 0
i = 1
while True:
    result = set()
    count += 1

    for j in arr:
        result.add(j[-1:-1 - i:-1])
    if len(result) == n:
        break

    i += 1

print(count)
