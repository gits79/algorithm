n, m = map(int, input().split())

count = 0

for i in range(1, n+1):
    count += str(i).count(str(m))

print(count)