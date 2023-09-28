import sys
input = lambda : sys.stdin.readline().strip()

s = input()
arr = [0] * 26
for i in s:
    arr[ord(i) - 97] += 1
print(*arr)