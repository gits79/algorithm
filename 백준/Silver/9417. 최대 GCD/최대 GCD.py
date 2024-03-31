import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())

def gcd(n, m):
    while m > 0:
        n, m = m, n % m
    return n


for _ in range(n):
    arr = list(map(int, input().split()))
    arr.sort()
    result = []
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if j == len(arr):
                break
            result.append(gcd(arr[i], arr[j]))

    print(max(result))