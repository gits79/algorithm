t = int(input())

for p in range(t):
    money = int(input())

    money_type = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    count = [0] * len(money_type)

    for i in range(len(money_type)):
        count[i] = money // money_type[i]
        money %= money_type[i]

    print(f'#{p + 1}')
    print(*count)