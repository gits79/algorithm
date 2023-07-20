arr = list(map(int,input().split()))

answer = 0
for i in range(1,10000001):
    count = 0
    for j in arr:
        if i % j == 0:
            count += 1
    if count >= 3:
        answer = i
        break

print(answer)


