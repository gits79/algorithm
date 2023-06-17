t = int(input())

for p in range(1, t + 1):
    n = int(input())

    count = 0
    for i in range(-n, n + 1):
        for j in range(-n, n + 1):
            if i ** 2 + j ** 2 <= n ** 2:
                count += 1

    print(f'#{p} {count}')