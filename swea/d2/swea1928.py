arr = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
       'W', 'X', 'Y', 'Z',
       'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
       'w', 'x', 'y', 'z',
       '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/']
t = int(input())

for p in range(1, t + 1):
    s = input()

    string_buffer = ""
    result = ""

    for i in s:
        num = arr.index(i)
        b_num = format(num, 'b').zfill(6)
        string_buffer += b_num

    for i in range(0, len(string_buffer), 8):
        temp_str = string_buffer[i:i + 8]
        num = int(temp_str, 2)
        new_str = chr(num)
        result += new_str

    print(f'#{p} {result}')