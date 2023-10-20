t = int(input())






for tc in range(1,t+1):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    visited = [False] * (n + 1)
    global count
    count = 0

    def recur(cur):
        global count
        if cur == n:
            summ = 0
            for i in range(n):
                if visited[i]:
                    summ += arr[i]
            if summ == k:
                count += 1
            return
        visited[cur] = False
        recur(cur + 1)
        visited[cur] = True
        recur(cur + 1)


    recur(0)
    print(f'#{tc} {count}')