import sys
input = lambda: sys.stdin.readline().strip()

k, n = map(int, input().split())
arr = []

for _ in range(k):
    arr.append(int(input()))

start = 1
end = 2 ** 31
answer = 0

while start <= end:

    mid = (start + end) // 2
    count = 0

    for i in arr:
        count += i // mid

    if count >= n:
        answer = max(answer, mid)
        start = mid + 1
    else:
        end = mid - 1

print(answer)