t = int(input())

for i in range(t):
    a = list(map(int, input().split()))
    a.remove(max(a))
    a.remove(min(a))
    result = round(sum(a) / len(a))
    print(f'#{i + 1} {result}')