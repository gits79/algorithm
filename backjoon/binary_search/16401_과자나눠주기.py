import sys
input = lambda: sys.stdin.readline().strip()

m, n = map(int, input().split())
arr = list(map(int, input().split()))

start = 1
end = 1_000_000_000
answer = 0

while start <= end:
    count = 0
    mid = (start + end) // 2

    for i in arr:
        count += i // mid

    if count >= m:
        answer = max(answer, mid)
        start = mid + 1
    else:
        end = mid - 1

print(answer)
