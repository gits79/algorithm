import sys

input = lambda: sys.stdin.readline().strip()


def binary_search(a, arr):
    start = 0
    end = len(arr) - 1
    result = False

    while start <= end:
        mid = (start + end) // 2

        if arr[mid][0] != a[0]:
            if arr[mid][0] < a[0]:
                start = mid + 1
            else:
                end = mid - 1
        else:
            if arr[mid][1] == a[1]:
                result = True
                break
            elif arr[mid][1] < a[1]:
                start = mid + 1
            else:
                end = mid - 1
    return result


k = int(input())
n, m = map(int, input().split())
arr = []

for _ in range(k):
    arr.append(list(map(int, input().split())))
arr.sort()
count = 0

for i in arr:
    temp = [i[0] + n, i[1] + m]
    if binary_search(temp, arr):
        if binary_search([i[0], i[1] + m], arr):
            if binary_search([i[0] + n, i[1]], arr):
                count += 1

print(count)
