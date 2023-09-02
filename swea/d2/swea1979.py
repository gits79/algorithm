t = int(input())

for p in range(t):
    n, k = map(int, input().split())
    a = []
    for i in range(n):
        a.append(list(map(int, input().split())))

    length = 0
    result = 0
    b = []
    # 가로
    for i in range(n):
        for j in range(n):
            if a[i][j] == 1:
                length += 1
            else:
                b.append(length)
                length = 0
        b.append(length)
        result += b.count(k)
        b.clear()
        length = 0
    # 세로
    for i in range(n):
        for j in range(n):
            if a[j][i] == 1:
                length += 1
            else:
                b.append(length)
                length = 0
        b.append(length)
        result += b.count(k)
        

    print(f'#{p + 1} {result}')