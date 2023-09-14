import sys

input = sys.stdin.readline

n = int(input())
i = 1
arr = []
answer = 0

while n > 0:
    if n < i * 9:
        arr.append(n)
        break
    else:
        n -= i * 9
        arr.append(i * 9)
    i *= 10

for i in range(len(arr)):
    answer += arr[i] * (i + 1)

print(answer)
