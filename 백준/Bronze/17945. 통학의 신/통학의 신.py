import sys
input = lambda: sys.stdin.readline().strip()

a, b = map(int, input().split())
result = []

result.append(int(-1 * a - (a**2 -1 * b) ** 0.5))
result.append(int(-1 * a + (a**2 -1 * b) ** 0.5))

result.sort()

if result[0] == result[1]:
    print(result[0])
else:
    print(*result)


