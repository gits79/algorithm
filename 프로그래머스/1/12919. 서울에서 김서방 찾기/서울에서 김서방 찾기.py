def solution(seoul):
    
    for i in range(len(seoul)):
        if seoul[i] == "Kim":
            index = i
    answer = f'김서방은 {index}에 있다'
    return answer