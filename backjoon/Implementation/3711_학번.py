import sys

input = lambda: sys.stdin.readline().strip()

t = int(input())
for tc in range(t):
    n = int(input())
    arr = []
    result = 0
    for _ in range(n):
        arr.append(int(input()))

    i = 1
    while True:
        temp = []
        for j in arr:
            temp.append(j % i)

        if len(temp) == len(set(temp)):
            result = i
            break

        i += 1


    print(i)
