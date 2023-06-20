
for p in range(1,11):

    n = int(input())
    arr = list(map(int, input().split()))
    k = int(input())
    queue = list(input().split())

    while queue:
        command = queue.pop(0)

        if command == "I":
            index = int(queue.pop(0)) + 1
            count = int(queue.pop(0))
            for i in range(count):
                num = int(queue.pop(0))
                arr.insert(index, num)
                index += 1

        elif command == "D":
            index = int(queue.pop(0)) + 1
            count = int(queue.pop(0))
            for i in range(count):
                arr.pop(index + 1)

        else:
            count = int(queue.pop(0))
            for i in range(count):
                num = int(queue.pop(0))
                arr.append(num)

    print(f'#{p}',end=" ")
    print(*arr[1:11])