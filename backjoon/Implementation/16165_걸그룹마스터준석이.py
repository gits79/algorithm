import sys
input = lambda : sys.stdin.readline().strip()

n, m = map(int, input().split())
arr_t = []
arr_m = []
for _ in range(n):
	team = input()
	temp = []
	num = int(input())
	for _ in range(num):
		temp.append(input())

	temp.sort()
	arr_m.append(temp)
	arr_t.append(team)

for _ in range(m):
	s = input()
	x = int(input())

	if x == 0:
		for i in range(n):
			if s == arr_t[i]:
				for j in arr_m[i]:
					print(j)
				break
	else:
		for i in range(n):
			for j in arr_m[i]:
				if j == s:
					print(arr_t[i])
					break