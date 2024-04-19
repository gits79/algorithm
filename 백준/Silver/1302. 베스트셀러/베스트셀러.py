import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = []
answer = ""
count = 0
for _ in range(n):
    arr.append(input())

arr.sort()

for i in arr:
    if arr.count(i) > count:
        answer = i
        count = arr.count(i)

print(answer)

