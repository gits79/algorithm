t = int(input())

for p in range(1,t+1):
    n = int(input())

    if n % 2 == 0:
        print(f'#{p} Even')
    else:
        print(f'#{p} Odd')