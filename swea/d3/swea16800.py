t = int(input())

for tc in range(1, t+1):
    n = int(input())
    result = []
    for i in range(1, int(n ** 0.5) + 1):
        if n % i == 0:
            result.append(i)

    a = result[-1]
    b = n // a
    print(f'#{tc} {a + b - 2}')