import sys

input = sys.stdin.readline

n = int(input())
new_n = n
count = 0

while True:

    if new_n < 10:
        new_n = "0" + str(new_n)
    else:
        new_n = str(new_n)

    a = new_n[-1]
    b = str(int(new_n[0]) + int(new_n[1]))
    b = b[-1]

    new_n = int(a + b)
    count += 1

    if new_n == n:
        break

print(count)
