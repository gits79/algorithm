numbers = [int(input()) for _ in range(7)]
numbers = [num for num in numbers if num % 2 == 1]
if numbers:
    print(sum(numbers))
    print(min(numbers))
else:
    print(-1)