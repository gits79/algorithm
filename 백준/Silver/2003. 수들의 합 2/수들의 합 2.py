n, m = map(int, input().split())
arr = list(map(int, input().split()))

count = 0
left = 0
right = 0
sum = arr[left]

while True:
    if sum == m:
        count += 1
        right += 1
        if right == n:
            break
        sum += arr[right]

    elif sum < m:
        right += 1
        if right == n:
            break
        sum += arr[right]

    else:
        sum -= arr[left]
        left += 1

print(count)