import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))

empty = [False] * 101
count = 0

for i in arr:
    if empty[i]:
        count += 1
    else:
        empty[i] = True

print(count)