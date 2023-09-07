n = int(input())

arr = list(map(int, input().split()))
arr.sort()

sum = int(input())

count = 0
left = 0
right = len(arr) - 1

while left < right:
    if arr[left] + arr[right] == sum:
        count += 1
        left += 1
        right -= 1
    elif arr[left] + arr[right] > sum:
        right -= 1
    else:
        left += 1

print(count)

