d1, d2, d3 = map(int, input().split())

if d1 == d2 == d3:
    print(10000 + d1 * 1000)
elif d1 == d2 or d1 == d3 or d2 == d3:
    print(1000 + d1 * 100) if d1 == d3 else print(1000 + d2 * 100)
else:
    print(max(d1, d2, d3) * 100)