li = [1, 2, 3]
for _ in range(int(input())):
    X, Y = map(int, input().split())
    x = li.index(X)
    y = li.index(Y)
    li[x], li[y] = li[y], li[x]
print(li[0])
