import itertools

arr = []
for _ in range(9):
    arr.append(int(input()))
result = []

comb = itertools.combinations(arr,7)


for i in comb:
    if sum(i) == 100:
        for j in i:
            result.append(j)
        break
result.sort()

for i in range(7):
    print(result[i])