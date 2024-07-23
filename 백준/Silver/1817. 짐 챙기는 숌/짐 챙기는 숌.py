import sys
input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())
if n == 0:
    print(0)
else:
    arr = list(map(int, input().split()))

    cnt = 0
    temp = 0
    for i in range(n):
        if temp + arr[i] < m:
            temp += arr[i]
        elif temp + arr[i] > m:
            cnt += 1
            temp = arr[i]
        else:
            cnt += 1
            temp = 0
    if temp > 0:
        print(cnt + 1)
    else:
        print(cnt)