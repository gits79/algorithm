import sys
input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())
arr = list(map(int, input().split()))

start = 0
end = max(arr) * m
answer = max(arr) * m + 1

while start <= end:
    mid = (start + end) // 2
    temp = 0

    for i in arr:
        temp += mid // i

    if temp >= m:
        answer = min(answer, mid)
        end = mid - 1
    else:
        start = mid + 1

print(answer)