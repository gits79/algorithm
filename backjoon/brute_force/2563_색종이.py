n = int(input())

arr = []
for _ in range(n):
    arr.append(list(map(int,input().split())))

square = [[0 for i in range(100)] for i in range(100)]

for i in arr:
    for j in range(10):
        for k in range(10):
            if square[i[0]+j][i[1]+k] == 0:
                square[i[0]+j][i[1]+k] = 1

result = []

for i in range(100):
    result.append(sum(square[i]))

print(sum(result))






