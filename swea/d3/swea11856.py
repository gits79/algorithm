t = int(input())

for tc in range(1, t+1):
    s = input()
    answer = "Yes"
    for i in s:
        if s.count(i) != 2:
            answer = "No"
            break	
    print(f'#{tc} {answer}')
