import sys
input = lambda: sys.stdin.readline().strip()

n, k = map(int, input().split())
arr = list(map(int, input().split()))

left = 0
right = 0
count = 0
answer = 0

while left <= right:

    if arr[right] % 2 == 1:
        count += 1

    answer = max(answer, right - left + 1 - count)

    if count > k:
        if arr[left] % 2 == 1:
            count -= 1
        left += 1

    right += 1
    if right == n:
        break

print(answer)
