import sys
input = lambda: sys.stdin.readline().strip()




n, m = map(int, input().split())
arr = []

for _ in range(m):
    arr.append(int(input()))

arr.sort()

result = 0

start = 1
end = max(arr)

while start <= end:
    mid = (start + end) // 2

    temp = 0
    for i in arr:
        temp += i // mid
        if i % mid != 0:
            temp += 1
    if temp > n:
        start = mid + 1

    else:
        end = mid - 1
        result = mid

print(result)

