import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
m = int(input())

arr = []

for i in range(int(n ** 0.5), int(m ** 0.5) + 1):
    if i ** 2 >= n and i ** 2 <= m:
        arr.append(i**2)

if len(arr) == 0:
    print(-1)
else:
    print(sum(arr))
    print(min(arr))