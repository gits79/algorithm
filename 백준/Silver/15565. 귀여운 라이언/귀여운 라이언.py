import sys
input = lambda: sys.stdin.readline().strip()

n, k = map(int, input().split())
arr = list(map(int, input().split()))
answer = []

left = 0
right = 0
count = 0

while left <= right:
    if arr[right] == 1:
        count += 1

    if count < k:
        right += 1
        if right == n:
            break

    else:
        answer.append(right - left + 1)
        if arr[left] == 1:
            count -= 1
        left += 1
        if arr[right] == 1:
            count -= 1
            
if answer:
    print(min(answer))
else:
    print(-1)