t = int(input())
num = ["0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"]

for p in range(1, t + 1):

    n, m = map(int, input().split())

    encode = ""
    for i in range(n):
        s = input()
        int_s = list(map(int, s))

        if sum(int_s) > 0:
            encode = s

    decode = ""

    i = -1
    while i > (-len(encode) + 6):
        for j in range(len(num)):
            if encode[i-7:i] == num[j]:
                decode += str(j)
                i -= 6
                break
        i -= 1

    decode = decode[::-1]


    sum_odd = 0
    sum_even = 0
    for i in range(len(decode)):
        if (i + 1) % 2 == 1:
            sum_odd += int(decode[i])
        else:
            sum_even += int(decode[i])

    result = 0
    if (sum_odd * 3 + sum_even) % 10 == 0:
        result = sum(list(map(int, decode)))

    print(f"#{p} {result}")