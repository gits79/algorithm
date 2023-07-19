n = int(input())


def add(count):
    for i in range(count):
        if i == count - 1:
            print("-", end=" ")
        else:
            print("-", end="")


for i in range(1, n + 1):
    temp = str(i)
    if temp.count("3") == 0 and temp.count("6") == 0 and temp.count("9") == 0:
        print(i, end=" ")
    else:
        count = temp.count("3") + temp.count("6") + temp.count("9")
        add(count)