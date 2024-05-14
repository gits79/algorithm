import sys
input = lambda : sys.stdin.readline().strip()

s = input()
n = len(s)
answer = []

def reverse(arr):
    return arr[::-1]

for i in range(n - 2):
    for j in range(i + 1, n - 1):
        temp = ""
        temp += reverse(s[0:i + 1]) + reverse(s[i+1:j + 1]) + reverse(s[j+1:n + 1])
        answer.append(temp)

answer.sort()
print(answer[0])