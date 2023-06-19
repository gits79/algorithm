num = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]

t = int(input())

for p in range(1,t+1):
    a,b = input().split()


    arr = input()



    # SVN을 문자열 7로 바꿈
    for i in range(len(num)):
        arr = arr.replace(num[i], str(i))
    # 문자열 7을 리스트로 정수형 7으로
    arr = list(map(int,arr.split()))
    arr.sort()
    # 다시 문자열
    arr = list(map(str,arr))
    arr = ' '.join(arr)

    for i in range(len(num)):
        arr = arr.replace(str(i), num[i])

    print(f'#{p}')
    print(arr)

