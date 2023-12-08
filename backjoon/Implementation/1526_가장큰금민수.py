import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
answer = 0

for i in range(4,n+1):
    temp = str(i)
    if len(temp) == temp.count("4") + temp.count("7"):
        answer = max(i, answer)

print(answer)

