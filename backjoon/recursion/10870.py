def pipo(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    c = pipo(n-1) + pipo(n-2)
    return c

n = int(input())
print(pipo(n))