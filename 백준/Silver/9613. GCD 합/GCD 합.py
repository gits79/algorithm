import sys
input = lambda: sys.stdin.readline().strip()


def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


t = int(input())

for tc in range(t):
    arr = list(map(int, input().split()))
    arr.pop(0)
    answer = []
    arr.sort()

    for i in range(len(arr) - 1):
        for j in range(i + 1, len(arr)):
            answer.append(gcd(arr[i], arr[j]))


    print(sum(answer))