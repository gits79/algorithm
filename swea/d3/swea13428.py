t = int(input())

for tc in range(1, t+1):
    n = int(input())
    lst = list(map(str, str(n)))
    result = [n]

    for i in range(len(lst)):
        for j in range(i+1,len(lst)):
            arr = lst.copy()
            temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp

            if arr[0] != '0':
                result.append(int(''.join(arr)))
    print(f'#{tc} {min(result)} {max(result)}')


