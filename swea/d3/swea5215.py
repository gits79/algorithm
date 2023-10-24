# t = int(input())
#
# for p in range(1, t + 1):
#
#     n, limit = map(int, input().split())
#
#     arr = []
#     result = []
#
#     for _ in range(n):
#         temp = list(map(int, input().split()))
#         arr.append(temp)
#     # arr[][0] = 점수 , arr[][1] = 칼로리
#     arr.sort(reverse=True)
#
#     for i in range(len(arr)):
#         score = arr[i][0]
#         cal = arr[i][1]
#         if cal > limit:
#             continue
#         for j in range(0,len(arr)):
#             if cal + arr[j][1] <= limit and i != j:
#                 cal += arr[j][1]
#                 score += arr[j][0]
#             result.append(score)
#
#     # print(result)
#     print(f'#{p} {max(result)}')

t = int(input())




for tc in range(1, t+1):
    n, L = map(int, input().split())
    arr = []
    result = []
    for _ in range(n):
        arr.append(list(map(int, input().split())))

    visited = [False] * (n + 1)


    def recur(cur):
        if cur == n:
            cal = 0
            for i in range(n):
                if visited[i]:
                    cal += arr[i][1]
            if cal <= L:
                summ = 0
                for j in range(n):
                    if visited[j]:
                        summ += arr[j][0]
                result.append(summ)

            return

        visited[cur] = False
        recur(cur + 1)
        visited[cur] = True
        recur(cur + 1)



    recur(0)
    print(f'#{tc} {max(result)}')