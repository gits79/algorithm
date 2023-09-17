import sys
input = sys.stdin.readline

result = 1
for _ in range(3):
    result *= int(input())

arr = [0] * 10
for i in str(result):
    arr[int(i)] += 1

for i in arr:
    print(i)