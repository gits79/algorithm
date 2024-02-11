import sys
input = lambda : sys.stdin.readline().strip()

n, k = map(int, input().split())
arr = list(map(int, input().split()))

answer = []

for i in range(n-k+1):
    temp = 0
    for j in range(i,i+k):
        temp += arr[j]
    answer.append(temp)

print(max(answer))
