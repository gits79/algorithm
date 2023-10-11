import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())

start = 1
end = 10 ** 800
answer = 0

while start <= end:
    mid = (start + end) // 2
    if mid ** 2 == n:
        answer = mid
        break
    elif mid ** 2 < n:
        start = mid + 1
    else:
        end = mid - 1

print(answer)