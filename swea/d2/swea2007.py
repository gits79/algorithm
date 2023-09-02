n = int(input())

str = []

for i in range(n):
    str.append(input())

for i in range(len(str)):
    for j in range(1, len(str[i])):
        if str[i][0:j] == str[i][j:2 * j]:

            print(f'#{i + 1} {len(str[i][0:j])}')
            break