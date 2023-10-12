import sys
input = lambda: sys.stdin.readline().strip()

s, c = map(int, input().split())
arr = []
for _ in range(s):
    arr.append(int(input()))

start = 1
end = 1_000_000_001
answer = 0

while start <= end:
    mid = (start + end) // 2
    count = 0

    for i in arr:
        count += i // mid

    if count >= c:
        answer = max(answer, mid)
        start = mid + 1
    else:
        end = mid - 1

result = sum(arr) - (answer * c)



print(result)