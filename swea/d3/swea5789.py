t = int(input())

for p in range(1,t+1):
    N, Q = map(int, input().split())
    arr = [0] * (N + 1)

    for i in range(1, Q + 1):
        L, R = map(int,input().split())
        for j in range(L,R+1):
            arr[j] = i


    print(f'#{p}',end=" ")
    print(*arr[1:])



