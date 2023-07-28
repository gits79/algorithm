t = int(input())

for p in range(t):
    n = int(input())

    a = list(map(int, input().split()))

    a.sort()

    print(f'#{p + 1}',end=" ")
    print(*a)
