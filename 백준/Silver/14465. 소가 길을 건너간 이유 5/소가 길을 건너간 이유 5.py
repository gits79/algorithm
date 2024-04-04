import sys
input = lambda: sys.stdin.readline().strip()

n, k, b = map(int, input().split())
arr = [False] * (n + 1)
for _ in range(b):
    arr[int(input())] = True

answer = []

left = 1
right = 1
count = 0
if arr[left]:
    count += 1

while left <= right:
    if right - left + 1 < k:
        right += 1
        if right == n + 1:
            break
        if arr[right]:
            count += 1

    elif right - left + 1 == k:
        answer.append(count)
        if arr[left]:
            count -= 1
        left += 1
        if right == n:
            break

print(min(answer))
