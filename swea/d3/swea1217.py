def recursion(a,b):
    if b == 0:
        return 1
    result = recursion(a,b-1) * a
    return result

for _ in range(10):
    t = int(input())
    a, b = map(int,input().split())

    print(f'#{t} {recursion(a,b)}')