import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = list(map(int,input().split()))


def isPrime(n):
    count = 0
    for i in range(2, n + 1):
        if n % i == 0:
            count += 1
    if count == 1:
        return True
    return False


count = 0
for i in arr:
    if isPrime(i):
        count += 1
print(count)
