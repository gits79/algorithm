import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))
m = int(input())

start = 1
end = 1_000_000_000
answer = 0

while start <= end:
    mid = (start + end) // 2
    if sum(arr) <= m:
        answer = max(arr)
        break
    else:
        count = 0

        for i in arr:
            count += min(i, mid)

        if count <= m:
            answer = max(answer, mid)
            start = mid + 1
        else:
            end = mid - 1

print(answer)
