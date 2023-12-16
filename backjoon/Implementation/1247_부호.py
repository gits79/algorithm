import sys
input = lambda : sys.stdin.readline().strip()

for tc in range(3):
	n = int(input())
	arr = []
	for _ in range(n):
		arr.append(int(input()))

	if sum(arr) == 0:
		print(0)
	elif sum(arr) < 0:
		print("-")
	else:
		print("+")