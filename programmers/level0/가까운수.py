def solution(array, n):
    answer = 0
    a = []
    for i in array:
        temp = n - i
        if temp < 0:
            temp = -temp
        a.append(temp)
    if a. count(min(a)) == 1:
        answer = array[a.index(min(a))]
    else:
        b = array[a.index(min(a))]
        array.remove(b)
        c = array[a.index(min(a))]
        answer = min(b,c)

    return answer