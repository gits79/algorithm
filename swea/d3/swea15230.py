t = int(input())

for tc in range(1, t+1):
    a, b = map(str, input().split())
    a = a * 100
    b = b * 100

    if a[:100] == b[:100]:
        print(f'#{tc} yes')
    else:
        print(f'#{tc} no')