n = int(input())
arr = list(map(int, input().split()))

left = 0
right = n - 1
init = abs(arr[left] + arr[right])
result = [arr[left], arr[right]]

while left < right:
    sum = arr[left] + arr[right]
    if abs(sum) < init:
        result.clear()
        result.append(arr[left])
        result.append(arr[right])
        init = abs(sum)
        if sum == 0:
            break

    if sum < 0:
        left += 1
    else:
        right -= 1
print(*result)