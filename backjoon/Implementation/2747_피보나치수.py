import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
arr = [0] * 46
arr[1] = 1
arr[2] = 1

for i in range(2,46):
    arr[i] = arr[i-1] + arr[i-2]

print(arr[n])