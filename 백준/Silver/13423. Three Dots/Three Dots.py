import sys
input = lambda: sys.stdin.readline().strip()

t = int(input())

for tc in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    answer = 0

    for i in range(n-2):
        start = arr[i]
        for j in range(i + 2, n):
            end = arr[j]

            if (start + end) % 2 == 0:
                left = i + 1
                right = j - 1

                while left <= right:
                    mid = (left + right) // 2

                    if (start + end) // 2 == arr[mid]:
                        answer += 1
                        break
                    elif (start + end) // 2 > arr[mid]:
                        left = mid + 1
                    else:
                        right = mid -1
    print(answer)
