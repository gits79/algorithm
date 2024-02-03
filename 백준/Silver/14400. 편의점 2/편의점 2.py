import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
x = []
y = []
for i in range(n):
    a, b = map(int, input().split())
    x.append(a)
    y.append(b)

x.sort()
y.sort()


answer = 0
mid = n // 2
temp = [x[mid], y[mid]]

for i in range(n):
    answer += abs(x[i] - temp[0]) + abs(y[i] - temp[1])
print(answer)

