import itertools

n = int(input())

arr = []
answer = "NO"

for i in range(21):
    arr.append(3 ** i)

j = 1
while j <= 20:

    comb = itertools.combinations(arr, j)

    for i in comb:
        if sum(i) == n:
            answer = "YES"
            break
    j += 1
print(answer)

