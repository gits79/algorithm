t = int(input())

for tc in range(1, t+1):
    s = input()
    a = s.count("o")
    b = s.count("x")
    c = 15 - a - b

    if a + c >= 8:
        print(f'#{tc} YES')
    else:
        print(f'#{tc} NO')