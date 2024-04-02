import sys
input = lambda: sys.stdin.readline().strip()

def gcd(a, b):
    while b > 0:
        a, b = b, a % b

    return a


def lcm(a, b):
    return a * b // gcd(a, b)


a, b = map(int, input().split())

if b > a:
    a, b = b, a

print(gcd(a, b))
print(lcm(a, b))
