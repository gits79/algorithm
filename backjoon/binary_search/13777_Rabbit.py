import sys
input = lambda: sys.stdin.readline().strip()
arr = [i for i in range(1, 51)]


while True:
    n = int(input())
    answer = []
    if n == 0:
        break
    start = 0
    end = 49

    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == n:
            answer.append(arr[mid])
            break

        elif arr[mid] < n:
            start = mid + 1
            answer.append(arr[mid])
        else:
            end = mid - 1
            answer.append(arr[mid])


    print(*answer)



