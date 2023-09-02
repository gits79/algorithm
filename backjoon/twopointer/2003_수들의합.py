n, m = map(int, input().split())
arr = list(map(int, input().split()))

count = 0
left = 0
right = 0
answer = arr[left]

# while True:
#     if answer == m:
#         count += 1
#         right += 1
#         if right == n:
#             break
#         answer += arr[right]
#
#     elif answer < m:
#         right += 1
#         if right == n:
#             break
#         answer += arr[right]
#
#     else:
#         answer -= arr[left]
#         left += 1

while True:
    if answer == m:
        count += 1
        right += 1
        if right == n:
            break
        answer = sum(arr[left:right + 1])

    elif answer < m:
        right += 1
        if right == n:
            break
        answer = sum(arr[left:right + 1])

    else:
        left += 1
        answer = sum(arr[left:right + 1])
print(count)
