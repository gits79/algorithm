import sys
input = lambda: sys.stdin.readline().strip()

t = int(input())
for tc in range(t):
    arr = []
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    count = 0

    for i in range(n - 2):
        start = arr[i]
        for j in range(i + 2, n):
            end = arr[j]

            if (start + end) % 2 == 0:
                left = 0
                right = n

                while left <= right:
                    mid = (left + right) // 2
                    if arr[mid] == (start + end) // 2:
                        count += 1
                        break
                    elif arr[mid] < (start + end) // 2:
                        left = mid + 1
                    else:
                        right = mid - 1

    print(count)
