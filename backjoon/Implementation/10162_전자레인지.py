import sys
input = lambda : sys.stdin.readline().strip()

t = int(input())
n = t
arr = [300, 60, 10]
result = [0, 0, 0]
answer = True

while n > 0:
    if n >= 300:
        result[0] += 1
        n -= 300
    elif n >= 60:
        result[1] += 1
        n -= 60
    elif n >= 10:
        result[2] += 1
        n -= 10
    elif n < 10:
        answer = False
        break

if answer:
    print(*result)
else:
    print(-1)

