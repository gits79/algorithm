def is_prime(n):
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True

num = int(input())

if num == 1:
    print(0)
else:
    arr = []
    i = 2
    while i <= num:
        if is_prime(i):
            arr.append(i)
        i += 1

    left = 0
    right = 0
    count = 0
    answer = arr[left]

    while True:
        if answer == num:
            count += 1
            right += 1
            if right == len(arr):
                break
            answer += arr[right]
        elif answer < num:
            right += 1
            if right == len(arr):
                break
            answer += arr[right]
        else:
            answer -= arr[left]
            left += 1

    print(count)
