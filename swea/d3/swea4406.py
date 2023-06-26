

t = int(input())

for p in range(1,t+1):

    s = input()

    arr = ["a","e","i","o","u"]

    result = ""
    for i in s:
        if i not in arr:
            result += i
    print(f'#{p} {result}')