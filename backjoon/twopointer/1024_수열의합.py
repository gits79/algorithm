import sys
input = lambda : sys.stdin.readline().strip()

n, l = map(int, input().split())

arr = [i for i in range(100000001)]
start = 0
end = 101

left = 0
right = 0
temp = arr[left]

while left <= right:

    if temp < n:
        right += 1
        if right == len(arr):
            break
        temp += arr[right]
    elif temp == n:
        if right - left + 1 >= l and end - start + 1 >= right - left + 1:
            start = left
            end = right
        right += 1
        if right == len(arr):
            break
        temp += arr[right]
    elif temp > n:
        temp -= arr[left]
        left += 1

if end - start == 101:
    print(-1)
else:
    print(*arr[start:end+1])

