t = int(input())

for tc in range(1, t+1):
    s = input()
    result = []

    for i in s:
        if i in result:
            result.remove(i)
        else:
            result.append(i)
    result.sort()
    answer = ''.join(result)
    if len(result) == 0:
        print(f'#{tc} Good')
    else:
        print(f'#{tc} {answer}')