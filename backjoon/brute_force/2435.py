n, k = map(int, input().split())
arr = list(map(int,input().split()))

answer = []

for i in range(n-(k-1)):
    answer.append(sum(arr[i:i+k]))
print(max(answer))
