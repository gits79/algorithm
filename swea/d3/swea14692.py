t = int(input())

for tc in range(1, t+1):
    n = int(input())
    if n % 2 == 0:
        print(f'#{tc} Alice')
    else:
        print(f'#{tc} Bob')