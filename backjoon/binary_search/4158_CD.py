import sys
input = lambda: sys.stdin.readline().strip()

while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break
    arr1 = []
    arr2 = []
    for _ in range(n):
        arr1.append(int(input()))
    for _ in range(m):
        arr2.append(int(input()))
    count = 0

    for i in arr1:
        start = 0
        end = m - 1

        while start <= end:
            mid = (start + end) // 2

            if arr2[mid] == i:
                count += 1
                break
            elif arr2[mid] < i:
                start = mid + 1
            else:
                end = mid - 1
    print(count)

