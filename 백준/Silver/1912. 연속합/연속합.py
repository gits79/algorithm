import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr =[0] + list(map(int, input().split())) + [0]

prefix = [0] * (n + 1)

for i in range(1, n + 1):
    prefix[i] = max(arr[i],  prefix[i - 1] + arr[i])

prefix.pop(0)
print(max(prefix))