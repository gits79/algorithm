import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))
arr.sort()

if n % 2 == 1:
    print(arr[len(arr) // 2])
else:
    print(arr[len(arr) // 2 - 1])