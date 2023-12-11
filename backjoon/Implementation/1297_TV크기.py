import sys
input = lambda: sys.stdin.readline().strip()

d, h, w = map(int, input().split())

x = d / ((h ** 2 + w ** 2) ** 0.5)

h = int(h * x)
w = int(w * x)

print(h, w)