t = int(input())

for tc in range(1, t+1):

    n = int(input())
    m = len(str(n))
    arr = list(map(int, str(n)))
    selected = [0] * m
    visited = [False] * (m + 1)
    result = []
    global answer
    answer = "impossible"

    if n < 10:
        print(f'#{tc} {answer}')

    else:
        for i in range(2, max(arr)+1):
            result.append(str(n * i))


        def recur(cur):
            global answer
            if cur == m:
                temp = ""
                for i in selected:
                    temp += str(i)
                if temp[0] != "0":
                    if temp in result:
                        answer = "possible"
                return

            for i in range(m):
                if visited[i]:
                    continue
                selected[cur] = arr[i]
                visited[i] = True
                recur(cur + 1)
                visited[i] = False


        recur(0)
        print(f'#{tc} {answer}')