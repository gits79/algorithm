h, w = map(int, input().split())
arr = list(map(int, input().split()))
arr.insert(0, 0)
arr.insert(len(arr), 0)

left = [0] * (w + 2)
right = [0] * (w + 2)
count = 0

for i in range(1, w + 1):
    left[i] = max(left[i - 1], arr[i])

for i in range(w, 0, -1):
    right[i] = max(right[i + 1], arr[i])

for i in range(1, w + 1):
    count += min(left[i], right[i]) - arr[i]

print(count)
