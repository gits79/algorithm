n, m = map(int, input().split())

arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))
result = []

left = 0
right = 0
while len(result) < n + m:
    if arr1[left] < arr2[right]:
        result.append(arr1[left])
        left += 1
        if left == n:
            arr1.append(10 ** 9 + 1)

    else:
        result.append(arr2[right])
        right += 1
        if right == m:
            arr2.append(10 ** 9 + 1)

print(*result)
