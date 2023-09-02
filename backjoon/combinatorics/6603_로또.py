import itertools
arr = list(map(int, input().split()))
while sum(arr) != 0:
    k = arr.pop(0)

    comb = itertools.combinations(arr, 6)
    for i in comb:
        print(*i)
    print()

    arr = list(map(int, input().split()))
