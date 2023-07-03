


t = int(input())

for p in range(1,t+1):
    k = int(input())
    result = [[] for i in range(k+1)]

    arr = list(map(int,input().split()))

    if len(arr) == 3:
        print(f'#{p}',end=" ")
        print(arr[1])
        print(arr[0],arr[2])

    else:
        mid = arr[len(arr)//2]
        level = k

        tree = []
        while arr:
            temp = arr.pop(0)
            if temp == mid:
                result[1].append(temp)
                k = level
            else:
                tree.append(temp)

            if len(tree) == 3:
                result[k].append(tree[0])
                result[k-1].append(tree[1])
                result[k].append(tree[2])
                k -= 1
                tree.clear()

        print(f'#{p}',end=" ")
        for i in result:
            print(*i)


# 8 4 9 2 10 5 11 1 12 6 13 3 14 7 15






# k = 4
# result = [[] for i in range(k+1)]
#
#
# arr = [8,4,9,2,10,5,11,1,12,6,13,3,14,7,15]
# mid = len(arr)//2
# left_arr = arr[:mid]
# right_arr = arr[mid+1:]
#
# level = k
#
# while left_arr:
#
