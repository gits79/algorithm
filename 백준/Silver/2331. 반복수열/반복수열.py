import sys
input = lambda: sys.stdin.readline().strip()


def func(n, m):
    answer = 0
    while n > 0:
        answer += (n % 10) ** m
        n //= 10
    answer += n ** m
    return answer


n, m = map(int, input().split())
arr = []
arr.append(n)
i = 0
while i <= 10000:
    temp = func(arr[-1], m)

    arr.append(temp)
    i += 1

answer = []
for i in arr:
    if arr.count(i) == 1:
        answer.append(i)

print(len(answer))


