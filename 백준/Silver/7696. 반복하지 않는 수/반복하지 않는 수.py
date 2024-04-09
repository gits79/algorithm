def duple2(n):
    is_chk = [True] * 10

    while n > 0:
        temp = n % 10
        n //= 10
        if is_chk[temp]:
            is_chk[temp] = False
        else:
            return False

    return True


arr = []
i = 1
while len(arr) <= 1_000_000:
    if duple2(i):
        arr.append(i)
    i += 1
while True:
    n = int(input())
    if n == 0:
        break
    print(arr[n-1])

