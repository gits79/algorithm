import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
a = 1
for i in range(1, n + 1):
    a *= i
print(a)
