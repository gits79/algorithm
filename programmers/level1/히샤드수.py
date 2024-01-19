def solution(x):
    answer = False
    a = list(map(int,str(x)))
    if x % sum(a) ==0:
        answer = True
    return answer