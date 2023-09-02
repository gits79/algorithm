n, k = map(int, input().split())

coins = []
for _ in range(n):
    coins.append(int(input()))
coins.sort(reverse= True)
count = 0

while k != 0:
    for coin in coins:
        if k >= coin:
            k -= coin
            count += 1
            break
print(count)