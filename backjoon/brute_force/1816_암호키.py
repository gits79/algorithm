n = int(input())

for _ in range(n):
    number = int(input())
    answer = "YES"

    for i in range(2, 10 ** 6 + 1):
        if number % i == 0:
            answer = "NO"
            break
    print(answer)
