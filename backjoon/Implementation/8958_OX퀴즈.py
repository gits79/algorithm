import sys
input = sys.stdin.readline

n = int(input())

for _ in range(n):
    score = 0
    temp = 1

    s = input().strip()

    for i in s:
        if i == "O":
            score += temp
            temp += 1
        else:
            temp = 1

    print(score)

