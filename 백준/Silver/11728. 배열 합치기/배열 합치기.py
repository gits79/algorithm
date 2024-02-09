import sys
input = lambda : sys.stdin.readline().strip()

n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

answer = []

left = 0
right = 0

while True:
    if a[left] < b[right]:
        answer.append(a[left])
        left += 1
        if left == n:
            for i in range(right,m):
                answer.append(b[i])
            break


    else:
        answer.append(b[right])
        right += 1
        if right == m:
            for i in range(left, n):
                answer.append(a[i])
            break

print(*answer)