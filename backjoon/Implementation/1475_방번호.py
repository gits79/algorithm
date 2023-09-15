import sys
input = sys.stdin.readline

n = int(input())
n = list(map(int, str(n)))
num1 = [0] * 11
num2 = [0] * 2

for i in n:
    if i == 6:
        num2[0] += 1
    elif i == 9:
        num2[1] += 1
    else:
        num1[i] += 1

one = max(num1)
two = max(num2) - ((max(num2) - min(num2)) // 2)
print(max(one, two))
