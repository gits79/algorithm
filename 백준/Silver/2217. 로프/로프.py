import sys
input = lambda : sys.stdin.readline()

n = int(input())

arr = []

for _ in range(n):
    arr.append(int(input()))

arr.sort(reverse= True)

max_v = 0
sum = 0
for i in range(n):
    sum += arr[i]
    temp = sum // (i + 1)
    if arr[i] * (i + 1) > temp:
        max_v = max(arr[i] * (i + 1), max_v)
    else:
        max_v = max(sum // (i + 1), max_v)

print(max_v)