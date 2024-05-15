import sys
input = lambda: sys.stdin.readline().strip()

arr = []

for _ in range(8):
    arr.append(int(input()))

b = sorted(arr, reverse= True)
print(sum(b[:5]))

answer = []
for i in range(5):
    answer.append(arr.index(b[i]) + 1)
answer.sort()

for i in answer:
    print(i, end=" ")