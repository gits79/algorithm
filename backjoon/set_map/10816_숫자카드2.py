n = int(input())
arr1 = list(map(int, input().split()))

m = int(input())
arr2 = list(map(int, input().split()))

lst1 = [0] * 10000001
lst2 = [0] * 10000001

for i in arr1:
    if i < 0:
        lst2[i] += 1
    else:
        lst1[i] += 1

for i in arr2:
    if i < 0:
        print(lst2[i], end=" ")
    else:
        print(lst1[i], end=" ")
