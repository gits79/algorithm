import sys
input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())
arr1 = []
arr2 = []

for _ in range(m):
    a, b = map(int, input().split())
    arr1.append(a)
    arr2.append(b)

summ = 0

while n > 0:
    if n >= 6:
        if min(arr1) > min(arr2) * 6:
            summ += min(arr2) * 6
        else:
            summ += min(arr1)
        n -= 6

    else:
        if min(arr1) > min(arr2) * n:
            summ += min(arr2) * n
        else:
            summ += min(arr1)

        n = 0



print(summ)
