n = int(input())

count = 0
for i in range(1, 101):
    if i % 2 == 1:
        continue
    for j in range(1, 101):
        for k in range(1, 101):
            if i % 2 == 0 and i >= 2 and j >= 1 and k >= 3 and k >= j + 2 \
                    and i + j + k == n:
                count += 1
print(count)
