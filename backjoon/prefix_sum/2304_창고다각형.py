n = int(input())
arr = [0] * (1000 + 2)
for _ in range(n):
    i, j = map(int, input().split())
    arr[i] = j

left = [0] * (1000 + 2)
right = [0] * (1000 + 2)
for i in range(1002):
    left[i] = max(arr[i], left[i - 1])

for i in range(-1, -1003, -1):
    right[i] = max(arr[i], right[i + 1])
answer = 0

for i in range(1, 1002):
    answer += min(left[i], right[i])
print(answer)
