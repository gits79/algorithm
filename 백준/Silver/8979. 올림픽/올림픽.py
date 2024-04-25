import sys
input = lambda: sys.stdin.readline().strip()

n, k = map(int, input().split())
arr = []

for _ in range(n):
    temp = list(map(int, input().split()))
    arr.append(temp)
arr.sort()

rank = arr[k - 1]
count = 1

for i in range(n):
    if i == k - 1:
        continue
    if arr[i][1] > rank[1]: # 금메달이 많은경우
        count += 1
    elif arr[i][1] == rank[1]: # 금메달은 같은 경우
        if arr[i][2] > rank[2]: # 은메달이 많은 경우
            count += 1
        elif arr[i][3] > rank[3] and arr[i][2] == rank[2]:
            count += 1

print(count)