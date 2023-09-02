t = int(input())

for p in range(1,t+1):
    s = input()
    # 글자를 거꾸로 뒤집어도 같으면 회문
    if s == s[::-1]:
        print(f'#{p} 1')
    else:
        print(f'#{p} 0')