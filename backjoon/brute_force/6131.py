n = int(input())
count = 0

for i in range(1,501):
    for j in range(1,501):
        if j ** 2 - i ** 2 == n:
            count += 1

print(count)
