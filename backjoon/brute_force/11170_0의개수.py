import sys
input = lambda: sys.stdin.readline().strip()


t = int(input())
for tc in range(t):
    n, m = map(int, input().split())
    arr = []
    count = 0

    for i in range(n, m+1):
        count += str(i).count("0")

    print(count)
