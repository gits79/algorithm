n, m = map(int, input().split())

arr1 = set()
arr2 = set()
count = 0
answer = []

for _ in range(n):
    arr1.add(input())

for _ in range(m):
    arr2.add(input())

lst = list(arr1 & arr2)
lst.sort()

print(len(lst))
for i in lst:
    print(i)
