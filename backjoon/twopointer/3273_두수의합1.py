n = int(input())
arr = list(map(int, input().split()))
x = int(input())

left = 0
right = n - 1
count = 0
arr.sort()

while left < right:
    sum = arr[left] + arr[right]
    if sum == x:
        count += 1
        left += 1
        right -= 1
    elif sum < x:
        left += 1
    else:
        right -= 1

print(count)
