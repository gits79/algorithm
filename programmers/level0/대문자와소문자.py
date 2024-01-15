def solution(my_string):
    answer = ''
    for i in range(len(my_string)):
        if my_string[i].isupper() == True:
            answer += my_string[i].lower()
        else:
            answer += my_string[i].upper()
    return answer
