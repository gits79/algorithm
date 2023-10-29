import sys
input = lambda : sys.stdin.readline().strip()

s = list(map(str,input().split("-")))
answer = ""

for i in s:
    answer += i[0]

print(answer)