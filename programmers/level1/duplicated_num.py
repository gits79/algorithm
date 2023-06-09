def solution(arr):
    answer = ["a"]

    while arr:
        temp = arr.pop(0)
        if answer[-1] != temp:
            answer.append(temp)
    answer.pop(0)
    return answer