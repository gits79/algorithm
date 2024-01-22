def solution(phone_number):
    answer = ''
    a = list(map(str,phone_number))
    for i in range(len(a)-4):
        a[i] = "*"
    answer = ''.join(a)
    return answer
