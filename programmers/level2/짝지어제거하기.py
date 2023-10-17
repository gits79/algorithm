def solution(s):
    answer = 0
    result = [1]

    for i in range(len(s)):
        temp = s[i]
        if result[-1] == temp:
            result.pop()
        else:
            result.append(temp)

    if len(result) == 1:
        answer = 1

    return answer