import sys
input = lambda: sys.stdin.readline().strip()

t = int(input())

for tc in range(t):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    a.sort()
    b.sort()
    result = 0


    for i in a:
        start = 0
        end = m - 1
        answer = -1


        while start <= end:
            mid = (start + end) // 2

            if i > b[mid]:
                answer = max(answer, mid)
                start = mid + 1
            else:
                end = mid - 1
        result += answer + 1

    print(result)