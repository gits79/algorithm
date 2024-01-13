def solution(n, k):
    if n <  10:
        answer = 12000 * n + 2000 * k
    else:
        answer = 12000 * n + 2000 * (k-n//10)
    return answer