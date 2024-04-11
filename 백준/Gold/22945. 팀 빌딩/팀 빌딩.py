import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))

left = 0
right = n - 1
answer = 0

while left <= right:
    min_v = min(arr[left], arr[right])
    answer = max(answer, min_v * (right - left - 1))

    if arr[left] <= arr[right]:
        left += 1
    else:
        right -= 1

print(answer)