t = int(input())

for tc in range(1, t+1):
    s = input()
    count = 0

    for i in s:
        temp = ord(i) - 97
        if temp == count:
            count += 1
        else:
            break
    print(f'#{tc} {count}')