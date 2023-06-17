t = int(input())

for p in range(t):

    n = int(input())
    a = []
    for i in range(n):
        a.append(list(input().split()))
    sumA = ""
    sumB = ""
    sumC = ""
    for i in range(n):
        for j in range(n - 1, -1, -1):
            sumA += a[j][i]
            sumB += a[-1 - i][j]
            sumC += a[-1 - j][-1 - i]

    print(f'#{p + 1}')
    for i in range(n):
        print(sumA[0 + n * i:n + n * i], sumB[0 + n * i:n + n * i], sumC[0 + n * i:n + n * i])