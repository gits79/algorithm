import sys
input = lambda: sys.stdin.readline().strip()

def binary_search(arr, k):
    answer = 0
    start = 0
    end = len(arr) - 1

    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == k:
            answer = 1
            break
        elif arr[mid] < k:
            start = mid + 1
        else:
            end = mid - 1

    return answer


n = int(input())
arr = list(map(int, input().split()))
arr.sort()
m = int(input())
lst = list(map(int, input().split()))


for i in lst:
    print(binary_search(arr, i))