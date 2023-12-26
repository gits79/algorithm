import sys
input = lambda : sys.stdin.readline().strip()

n, m = map(int, input().split())

arr = [[0 for i in range(101)] for i in range(101)]

for _ in range(n):
	a, b, c, d = map(int, input().split())
	for i in range(a,c+1):
		for j in range(b,d+1):
			arr[i][j] += 1

count = 0

for i in range(101):
	for j in range(101):
		if arr[i][j] > m:
			count += 1
print(count)
