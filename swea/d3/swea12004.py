t = int(input())

for tc in range(1, t+1):
    n = int(input())

    for i in range(1, 10):
        if n % i == 0:
            a = i

    b = n // a

    if a >= 1 and a <= 9 and b >= 1 and b <= 9:
        print(f'#{tc} Yes')
    else:
        print(f'#{tc} No')