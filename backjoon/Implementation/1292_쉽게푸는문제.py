import sys
input = lambda: sys.stdin.readline().strip()

arr = []
a, b = map(int, input().split())
for i in range(1,200):
    for j in range(i):
        arr.append(i)

print(sum(arr[a-1:b]))
