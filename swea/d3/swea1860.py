t = int(input())

for p in range(1,t+1):

    n, m, k = map(int,input().split())
    time = list(map(int,input().split()))
    time.sort()

    if 0 in time:
        result = "Impossible"
    else:


        count = 0
        result = "Possible"

        i = 1
        while i <= time[-1]:
            if i % m == 0:
                count += k
            if i in time:
                count -= 1
            if count < 0:
                result = "Impossible"
                break

            i += 1

    print(f'#{p} {result}')