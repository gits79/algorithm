import sys
input = lambda: sys.stdin.readline().strip()

n, k = map(int, input().split())
arr = list(map(int, input().split()))
answer = []

left = 0
right = 0
summ = arr[right]

while left <= right:


    if summ < k:
        right += 1
        if right == n:
            break
        summ += arr[right]
    else:
        answer.append(right - left + 1)
        summ -= arr[left]
        left += 1

if answer:
    print(min(answer))
else:
    print(0)