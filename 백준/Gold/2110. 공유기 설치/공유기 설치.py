import sys
input = lambda: sys.stdin.readline().strip()

n, c = map(int, input().split())
arr = []

for _ in range(n):
    arr.append(int(input()))

arr.sort()

start = 1
end = max(arr) + 1
answer = 0

while start <= end:
    mid = (start + end) // 2
    temp = arr[0]
    count = 1

    for i in range(1, n):
        if arr[i] - temp >= mid:
            count += 1
            temp = arr[i]

    if count >= c:
        answer = max(answer, mid)
        start = mid + 1

    else:
        end = mid - 1


print(answer)
