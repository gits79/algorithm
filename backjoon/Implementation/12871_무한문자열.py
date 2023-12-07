import sys
input = lambda : sys.stdin.readline().strip()

s = input()
t = input()

s = s * 100
t = t * 100

if s[:100] == t[:100]:
    print(1)
else:
    print(0)