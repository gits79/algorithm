t = int(input())

for p in range(1,t+1):
    n , m = map(int,input().split())

    # 전체 수강생
    arr = [i+1 for i in range(n)]
    # 제출자
    submit = list(map(int,input().split()))

    print(f'#{p}',end=" ")
    # 전체 수강생중
    for i in arr:
        # 제출자 명단에 없다면
        if i not in submit:
            print(i,end=" ")
    print()
