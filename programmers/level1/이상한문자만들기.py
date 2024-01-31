def solution(s):
    answer = ''
    arr = list(map(str, s.split()))

    for i in arr:
        for j in range(len(i)):
            if j % 2 == 0:
                answer += i[j].upper()
            else:
                answer += i[j].lower()
        answer += " "
    answer = answer.rstrip()

    return answer