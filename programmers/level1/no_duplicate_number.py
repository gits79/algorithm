def solution(arr):
    answer = []
    result = set()

    for i in arr:
        if i not in answer:
            answer.append(i)


    return answer