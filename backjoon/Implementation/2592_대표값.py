import sys
input = lambda: sys.stdin.readline().strip()

arr = []

for i in range(10):
    arr.append(int(input()))


num = [0] * 1001
for i in arr:
    num[i] += 1

print(sum(arr) // 10)
print(num.index(max(num)))