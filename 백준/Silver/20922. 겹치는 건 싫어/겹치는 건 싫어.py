n, k = map(int, input().split())
arr = list(map(int, input().split()))

num = [0 for i in range(100001)]
length = 0
left = 0
right = 0

num[arr[right]] += 1

while True:
    if num[arr[right]] > k:
        num[arr[left]] -= 1
        left += 1
    else:
        length = max(length, right - left + 1)
        right += 1
        if right == n:
            break
        num[arr[right]] += 1


print(length)









