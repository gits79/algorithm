m = int(input())


def array(n):
    arr = []
    for i in range(n):
        temp = [0] * n
        arr.append(temp)
    arr[0][0] = 1
    return arr


#    상 , 하 , 좌 ,우
d = [(0, 1), (1, 0), (0, -1), (-1, 0)]


# 방향
def turn(z):
    if z == 3:
        z = 0
    else:
        z += 1
    return z


def go(arr, x, y, z, start):

    while (start != n ** 2 + 1):

        if x + d[z][0] < 0 or x + d[z][0] > n - 1 or y + d[z][1] < 0 or y + d[z][1] > n - 1 \
                or arr[x + d[z][0]][y + d[z][1]] != 0:
            z = turn(z)

        elif arr[x + d[z][0]][y + d[z][1]] == 0:
            arr[x + d[z][0]][y + d[z][1]] = start
            x += d[z][0]
            y += d[z][1]
            start += 1

    # print(a)
    for i in range(len(arr[0])):
        for j in range(len(arr[0])):
            print(arr[i][j], end=" ")
        print()


for i in range(m):

    n = int(input())
    print(f"#{i + 1}")

    if n == 1:
        print(1)
    else:
        go(array(n), 0, 0, 0, 2)
