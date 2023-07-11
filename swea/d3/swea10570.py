t = int(input())

def is_square(n):
    if n <= 9:
        return True
    str_num = str(n)
    mid = len(str_num) // 2
    if len(str_num) % 2 == 0:
        if str_num[0:mid] == str_num[-1:mid - 1:-1]:
            return True
    else:
        if str_num[0:mid] == str_num[-1:mid:-1]:
            return True

    return False


for p in range(1,t+1):





    a, b = map(int, input().split())
    count = 0
    for i in range(a, b + 1):
        if is_square(i):
            if int(i ** 0.5) == i ** 0.5:
                if is_square(int(i ** 0.5)):

                    count += 1
    print(f'#{p} {count}')
