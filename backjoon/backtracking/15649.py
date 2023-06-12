from itertools import permutations,combinations


def recursion(arr,n):
    if n == 0:
        return


n, m = map(int,input().split())

arr = [i+1 for i in range(n)]
arr = [1,2,3,4,1,2,3,4]
arr.sort()


b = list(permutations(arr,m))
b = set(b)

for i in b:
    for j in range(len(i)):
        print(*i)