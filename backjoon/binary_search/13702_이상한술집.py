import sys
input = lambda: sys.stdin.readline().strip()

n, k = map(int, input().split())
arr = []

for _ in range(n):
    arr.append(int(input()))

start = 1
end = 2 ** 31
answer = 0

while start <= end:

    mid = (start + end) // 2
    count = 0

    for i in arr:
        count += i // mid

    if count >= k:
        answer = max(answer, mid)
        start = mid + 1
    else:
        end = mid - 1

print(answer)