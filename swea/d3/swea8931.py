t = int(input())

for p in range(1,t+1):

    n = int(input())
    stack = ["a"]

    for i in range(n):
        num = int(input())
        if num != 0:
            stack.append(num)
        else:
            stack.pop()

    print(f'#{p} {sum(stack[1:])}')
