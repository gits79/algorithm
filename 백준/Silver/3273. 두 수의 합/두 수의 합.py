import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))
arr.sort()
x = int(input())
count = 0

left = 0
right = n - 1

while left < right:
    if arr[left] + arr[right] == x:
        count += 1
        left += 1
        

    elif arr[left] + arr[right] < x:
        left += 1
    else:
        right -= 1

print(count)
