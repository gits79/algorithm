import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
answer = []

left = 1
right = 1

while left <= right:

    if right ** 2 - left ** 2 < n:
        right += 1
        if right == 1000000:
            break

    elif right ** 2 - left ** 2 == n:
        answer.append(right)
        left += 1

    else:
        left += 1

if len(answer) == 0:
    print(-1)

else:
    for i in answer:
        print(i)