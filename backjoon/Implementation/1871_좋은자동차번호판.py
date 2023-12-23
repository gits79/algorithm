import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
for _ in range(n):
    a, b = map(str, input().split("-"))
    c = 0
    for i in range(3):
        c += (ord(a[i]) - 65) * 26 ** (2 - i)
    if abs(c - int(b)) <= 100:
        print("nice")
    else:
        print("not nice")
