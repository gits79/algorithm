import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
m = n // 2

start = 0
end = m + 1
answer = m + 2

while start <= end:
    mid = (start + end) // 2

    if mid ** 2 >= n:
        answer = min(answer, mid)
        end = mid - 1

    else:
        start = mid + 1

print(answer)

