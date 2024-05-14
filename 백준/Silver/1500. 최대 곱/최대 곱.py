import sys
input = lambda: sys.stdin.readline().strip()

n, k = map(int, input().split())

div = n // k
arr = [div] * k
per = n % k

for i in range(per):
    arr[i] += 1

temp = 1
for i in range(k):
    temp *= arr[i]

print(temp)
