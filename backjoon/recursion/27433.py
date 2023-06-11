def factorial(n):
    if n == 0:
        return 1

    result = factorial(n-1) * n
    return result


print(factorial(10))