import sys
input = lambda: sys.stdin.readline().strip()

a, b, n, w = map(int, input().split())
count = 0
answer = []

for i in range(1, n):
    if a * i + (n - i) * b == w:
        answer.append(i)
        answer.append(n-i)
        count += 1

if count == 1:
    print(*answer)
else:
    print(-1)
