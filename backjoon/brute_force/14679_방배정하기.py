a, b, c, n = map(int, input().split())

answer = 0
for i in range(0,n+1):
    for j in range(0,n-i):
        for k in range(0,n-i-j):
            if a * i + b * j + c * k == n:
                answer = 1
                break


print(answer)