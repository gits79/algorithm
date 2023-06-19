for k in range(1, 11):
    t = int(input())

    arr = list(map(int, input().split()))

    while min(arr) != 0:
        for i in range(1, 6):
            temp = arr.pop(0) - i

            if temp <= 0:
                arr.append(0)
                break
            else:
                arr.append(temp)

    result = ' '.join(map(str, arr))
    print(f'#{k} {result}')