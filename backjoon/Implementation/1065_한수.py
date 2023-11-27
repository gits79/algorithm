import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())


def check(n):
    result = []
    while n != 0:
        temp = n % 10
        n //= 10
        result.append(temp)

    if len(result) < 2:
        return True
    else:
        sub = result[0] - result[1]
        for i in range(1, len(result) - 1):
            if result[i] - result[i + 1] != sub:
                return False
        return True


count = 0

for i in range(1, n + 1):
    if check(i):
        count += 1

print(count)
