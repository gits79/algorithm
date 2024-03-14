import sys
input = lambda: sys.stdin.readline().strip()

n, k = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

answer = 0
start = 0
end = 1_000_000_000

while start <= end:
    mid = (start + end) // 2
    temp = 0

    for i in arr:
        if i - mid > 0:
            temp += i - mid

    if temp >= k:
        answer = max(answer, mid)
        start = mid + 1
    else:
        end = mid - 1

print(answer)