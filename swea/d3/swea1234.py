for i in range(10):
    n, arr = map(str,input().split())
    queue = list(arr)
    result = ["a"]

    while queue:
        temp = queue.pop(0)
        if result[-1] != temp:
            result.append(temp)
        else:
            result.pop()
    print(f'#{i+1}',end=" ")
    print(''.join(result[1:]))

