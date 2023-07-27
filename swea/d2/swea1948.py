t = int(input())

day = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]


def sum_day(array, n):
    sum = 0
    for i in range(n-1):
        sum += array[i]
    return sum


for p in range(t):
    m1, d1, m2, d2 = map(int, input().split())
    result = sum_day(day, m2) - sum_day(day, m1) + (d2 - d1) + 1
    print(f'#{p + 1} {result}')

