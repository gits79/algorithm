def solution(s):
    answer = ''
    if len(s) % 2 == 1:
        mid = len(s) // 2
        answer += s[mid]
    else:
        mid = len(s) // 2
        answer += s[mid-1] + s[mid]
    return answer