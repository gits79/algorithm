t = int(input())

for p in range(1,t+1):

    arr = list(map(int,input().split()))
    result = []
    for i in range(len(arr)):
        for j in range(i+1,len(arr)):
            for k in range(j+1,len(arr)):
                result.append(arr[i]+arr[j]+arr[k])
                print(arr[i],arr[j],arr[k])


    result.sort()
    print(result)
    print(f'#{p} {result[-5]}')


from itertools import combinations, permutations

t = int(input())

for p in range(1,t+1):
    arr = list(map(int,input().split()))
    combi = list(combinations(arr, 3))
    print(combi)
    result = set()

    for i in combi:
        result.add(sum(i))

    result = list(result)
    result.sort()
    print(result[-5])
