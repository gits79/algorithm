n = int(input())
arr = []
for _ in range(n):
    arr.append(input())

arr2 = []
m = int(input())
for _ in range(m):
    arr2.append(input())

index = arr.index("?")

if index == 0 and n != 1:
    end = arr[index + 1][0]
    for i in arr2:
        if i.endswith(end) and i not in arr:
            print(i)
elif index == 0 and n == 1:
    print(arr2[0])
elif index == len(arr) - 1:
    start = arr[index - 1][-1]
    for i in arr2:
        if i.startswith(start) and i not in arr:
            print(i)
else:
    start = arr[index - 1][-1]
    end = arr[index + 1][0]


    for i in arr2:
        if i.startswith(start) and i.endswith(end) and i not in arr:
            print(i)