def solution(n):
    answer = -1
    num = n ** 0.5
    if int(num) ** 2 == n:
        answer = (int(num) + 1) ** 2
    return answer