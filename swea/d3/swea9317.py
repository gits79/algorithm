t = int(input())

for tc in range(t):
    n = int(input())
    answer = input()
    comment = input()
    count = 0

    for i in range(len(answer)):
        if answer[i] == comment[i]:
            count += 1

    print(f'#{tc + 1} {count}')