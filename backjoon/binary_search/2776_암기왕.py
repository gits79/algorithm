import sys
input = lambda: sys.stdin.readline().strip()

t = int(input())

for tc in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    m = int(input())
    lst = list(map(int, input().split()))

    for i in lst:
        left = 0
        right = n - 1
        answer = 0

        while left <= right:
            mid = (left + right) // 2
            if arr[mid] == i:
                answer = 1
                break
            elif arr[mid] < i:
                left = mid + 1
            else:
                right = mid - 1

        print(answer)



