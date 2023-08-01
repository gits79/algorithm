n = int(input())

arr = []

for _ in range(n):
    arr.append(list(map(int, input().split())))

gap = []
for i in range(1, len(arr)):
    sub = abs(arr[i][0] - arr[i-1][0]) + abs(arr[i][1] - arr[i-1][1])
    gap.append(sub)

result = []
sum_gap = sum(gap)
for i in range(1,len(arr) - 1):
    length = sum_gap
    length -= gap[i-1] + gap[i]
    length += abs(arr[i-1][0] - arr[i+1][0]) + abs(arr[i-1][1] - arr[i+1][1])
    result.append(length)
print(min(result))