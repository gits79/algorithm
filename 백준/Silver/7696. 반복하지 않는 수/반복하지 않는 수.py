def duple2(n):
    is_chk = [False] * 10
    n = str(n)
    for i in n:
        if is_chk[int(i)]:
            return False
        else:
            is_chk[int(i)] = True
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

