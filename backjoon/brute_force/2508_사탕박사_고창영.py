t = int(input())


for _ in range(t):
    space = input()
    r, c = map(int, input().split())
    answer = 0

    row = []

    for _ in range(r):
        row.append(input())

    candy = ">o<"
    # for i in row:
    #
    #     if candy in i:
    #         print(i)
    #         answer += 1
    for i in row:
        answer += i.count(candy)

    col = list(map(list, zip(*row)))



    candy = "vo^"

    for i in col:
        temp = ''.join(i)
        answer += temp.count(candy)

    # for i in col:
    #     temp = ''.join(i)
    #     if temp.startswith(candy) or temp.endswith(candy):
    #         answer += 1
    #         print(temp)

    print(answer)
