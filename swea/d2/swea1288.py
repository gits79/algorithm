t = int(input())

for tc in range(t):
    s = input().strip()

    if s == s[::-1]:
        print(f'#{tc+1} 1')
    else:
        print(f'#{tc+1} 0')