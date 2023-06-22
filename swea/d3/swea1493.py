n = 5

arr = [[1,3,6,10],[2,5,9,14],[4,8,13,19],[7,12,18,25]]

for i in arr:
    print(i)

print(arr[0][1])

arr2 = []

i= 1
plus = 1
s = 1
while s <= n:
    arr2.append(i)
    plus += 1
    i += plus
    s += 1
print(arr2)

num = 1
plus = 1

for i in range(n):
    print(num)
    plus += 1
    num += plus
