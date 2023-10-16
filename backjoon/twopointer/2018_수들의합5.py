import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())


count = 0
answer = 0
left = 0
right = 0


while left <= n:
    if answer < n:
        right += 1
        answer += right

    elif answer > n:
        answer -= left
        left += 1

    else:
        count += 1
        right += 1
        answer += right


print(count)





