import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = []

for _ in range(n):
    arr.append(list(map(int, input().split())))

arr.sort(key=lambda x: x[2], reverse=True)

num = [0] * (n + 1)
count = 0
for i in arr:
    if count == 3:
        break
    if num[i[0]] < 2:
        print(i[0], i[1])
        num[i[0]] += 1
        count += 1
