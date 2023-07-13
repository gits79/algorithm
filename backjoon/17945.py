# x^2 + 2Ax + B = 0

A, B = map(int, input().split())
# a * b = B
# a + b = 2A

result = []
for a in range(-1000, 1000):
    if a == 0: continue

    if A == 0 or B == 0:
        print(0)
        break

    if B > 0:
        if A < 0 and B ** 0.5 == int(B ** 0.5):
            print(int(B ** 0.5))
            break
        elif A > 0 and B ** 0.5 == int(B ** 0.5):
            print(int(B ** 0.5) * -1)
            break

    if B % a == 0:
        b = int(B / a)
        if a + b == -2 * A:
            result.append(a)
            result.append(b)
            result.sort()
            print(*result[:])
            break
