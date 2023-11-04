import sys
input = lambda : sys.stdin.readline().strip()

t = int(input())
n = 100
m = 100

for i in range(t):
    a, b = map(int, input().split())
    if a < b:
        n -= b
    elif a > b:
        m -= a

print(n)
print(m)