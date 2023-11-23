t = int(input())

for tc in range(1, t + 1) :
    data = input()
    result = ""

    for i in range(len(data) - 1, -1, -1) :
        if data[i] == 'b' :
            result += 'd'
        elif data[i] == 'd' :
            result += 'b'
        elif data[i] == 'p' :
            result += 'q'
        else :
            result += 'p'

    print(f'#{tc} {result}')