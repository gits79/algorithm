n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

priority = [0] * n

a.sort()
b.sort(reverse= True)
answer = 0
for i in range(n):
    answer += a[i] * b[i]
print(answer)