import sys
input = lambda : sys.stdin.readline().strip()

while True:
    arr = list(map(int, input().split()))
    if sum(arr) == -1:
        break

    count = 0

    for i in range(len(arr) - 1):
        if arr[i] * 2 in arr:
            count += 1

    print(count)