t = int(input())

for tc in range(1, t+1):
    n = int(input())
    arr = list(map(int, input().split()))
    count = 0

    for j in range(1, n - 1):
        temp = arr[j - 1:j + 2]
        if arr[j] != max(temp) and arr[j] != min(temp):
            count += 1
    print(f'#{tc} {count}')
