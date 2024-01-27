def solution(n):
    result = ""

    while n > 1:
        result += str(n % 3)
        n //= 3
        if n == 1:
            result += "1"

    answer = 0
    for i in range(len(result)):
        answer += int(result[i]) * 3 ** (len(result) - 1 - i)

    if answer == 0:
        answer = 1
    return answer


