t = int(input())

for p in range(t):
    h1, m1, h2, m2 = map(int, input().split())

    h_count = 0

    if (m1 + m2) < 60:
        minute = m1 + m2
        hour = h1 + h2
    else:
        minute = m1 + m2 - 60
        h_count += 1

    if (h1 + h2) > 12:
        hour = h1 + h2 + h_count - 12
    else:
        hour = h1 + h2 + h_count

    print(f'#{p + 1} {hour} {minute}')