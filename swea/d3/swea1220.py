
for p in range(1,11):
    n = int(input())
    arr = []

    for _ in range(100):
        arr.append(list(map(int,input().split())))
    count = 0

    for i in range(100):
        stack = ["a"]
        for j in range(100):
            temp = arr[j][i]
            # N 극을 만나면 스택에 N극이 없다면 N극을 넣음
            if temp == 1:
                # N 극을 연속으로 만나도 교착은 하나기 때문에 더 넣지 않음
                if stack[-1] != 1:
                    stack.append(temp)
            # S 극을 만나면 스택에 N극이 있다면 교착 스택에서 교착상태 제거
            elif temp == 2:
                if stack[-1] == 1:
                    count += 1
                    stack.pop(-1)

    print(f'#{p} {count}')




