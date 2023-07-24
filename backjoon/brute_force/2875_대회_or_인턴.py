n, m, k = map(int, input().split())

answer = []
for i in range(k + 1):
    x = n - i
    y = m - (k - i)
    count = min(x // 2, y)
    answer.append(count)

print(max(answer))
