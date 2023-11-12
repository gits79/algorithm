t = int(input())

for tc in range(1, t+1):
    n = int(input())
    s = input()

    if n % 2 == 1:
        print(f'#{tc} No')
    else:
        mid = n // 2

        if s[:mid] == s[mid:]:
            print(f'#{tc} Yes')
        else:
            print(f'#{tc} No')
