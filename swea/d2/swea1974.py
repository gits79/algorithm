t = int(input())

for p in range(1, t + 1):

    arr = []
    result = 1
    for _ in range(9):
        temp = list(map(int, input().split()))
        # 가로
        if len(set(temp)) != 9:
            result = 0
        arr.append(temp)

    # 세로
    for i in range(9):
        setA = set()
        for j in range(9):
            setA.add(arr[j][i])

        if len(setA) != 9:
            result = 0
            break

    # 3 x 3
    for i in range(3):
        for j in range(3):
            arr1 = arr[i * 3][j * 3:j * 3 + 3]
            arr2 = arr[i * 3 + 1][j * 3:j * 3 + 3]
            arr3 = arr[i * 3 + 2][j * 3:j * 3 + 3]
            new_arr = arr1 + arr2 + arr3

            if len((set(new_arr))) != 9:
                result = 0
                break

    print(f'#{p} {result}')
