import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())

for tc in range(1, n + 1):
    arr = list(map(int, input().split()))
    arr.pop(0)
    count = 0

    for i in range(20):
        for j in range(0, i):
            if arr[i] < arr[j]:
                arr[i], arr[j] = arr[j], arr[i]
                count += 1

    print(f'{tc} {count}')
