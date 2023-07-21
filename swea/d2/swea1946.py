t = int(input())

for p in range(t):
    n = int(input())

    arr = []
    for i in range(n):
        str, num = input().split()

        for j in range(int(num)):
            arr.append(str)


    print(f'#{p + 1}')
    for i in range(0,len(arr),10):
        print(''.join(arr[i:i+10]))
