import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))


start = 1
end = 10 ** 9
answer = 0

while start <= end:
    mid = (start + end) // 2


    if n < mid:
        end = mid - 1
    flag = False
    count = 0
    result = 0
    for i in arr:
        if not flag:
            if i - mid >= 0:
                count += 1
                flag = True

        else:
            if i - mid >= 0:
                count += 1
            else:
                result = max(result, count)
                count = 0
                flag = False
    result = max(result, count)


    if result >= mid:
        answer = max(answer, mid)
        start = mid + 1
    else:
        end = mid - 1

print(answer)
