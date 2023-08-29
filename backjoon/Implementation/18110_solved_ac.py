n = int(input())

arr = []

if n == 0:
    print(0)
else:

    for _ in range(n):
        arr.append(int(input()))

    cut = int(n * 0.15 + 0.5)
    arr.sort()

    print(int(sum(arr[cut:len(arr) - cut]) / (len(arr) - (2 * cut)) + 0.5))
