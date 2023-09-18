import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
arr = list(map(int, input().split()))
arr.sort()

left = 0
right = n - 1
count = 0

while left < right:
    temp = arr[left] + arr[right]

    if temp == m:
        count += 1
        left += 1
        right -= 1

    elif temp < m:
        left += 1

    else:
        right -= 1

print(count)
