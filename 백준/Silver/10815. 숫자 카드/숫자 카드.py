import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))
m = int(input())
lst = list(map(int, input().split()))
arr.sort()


answer = []

for i in lst:
    start = 0
    end = n - 1
    flag = False

    while start <= end:
        mid = (start + end) // 2

        if arr[mid] == i:
            flag = True
            break
        elif arr[mid] > i:
            end = mid - 1
        else:
            start = mid + 1

    if flag:
        answer.append(1)
    else:
        answer.append(0)

print(*answer)