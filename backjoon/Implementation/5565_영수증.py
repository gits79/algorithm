import sys
input = lambda : sys.stdin.readline().strip()


answer = int(input())
n = 0
for i in range(9):
    n += int(input())

print(answer - n)