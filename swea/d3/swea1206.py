t = 10

for p in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    count = 0

    for i in range(2, len(a) - 2):
        if a[i] > a[i + 1] and a[i] > a[i + 2] and a[i] > a[i - 1] and a[i] > a[i - 2]:
            count += a[i] - max(a[i - 1], a[i - 2], a[i + 1], a[i + 2])

    print(f'#{p + 1} {count}')