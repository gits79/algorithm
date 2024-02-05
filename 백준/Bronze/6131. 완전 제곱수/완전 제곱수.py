import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
count = 0

for i in range(1, 501):
    for j in range(1, 501):
        if i ** 2 == j ** 2 + n:
            count += 1
print(count)
