import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    arr.append(input().strip())

if arr == sorted(arr):
    print("INCREASING")
elif arr == sorted(arr, reverse=True):
    print("DECREASING")
else:
    print("NEITHER")