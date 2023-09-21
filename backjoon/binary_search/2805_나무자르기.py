import sys
input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())
arr = list(map(int, input().split()))

start = 1
end = 2000000001
length = 0

while start <= end:
    answer = 0
    mid = (start + end) // 2

    for i in arr:
        if i - mid > 0:
            answer += i - mid

    if answer >= m:
        start = mid + 1
        length = max(length, mid)

    elif answer < m:
        end = mid - 1

print(length)