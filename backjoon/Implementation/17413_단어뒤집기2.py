import sys
input = sys.stdin.readline

s = list(input())
s.pop()
flag = 0
answer = ""
init = ""

while s:
    temp = s.pop(0)

    if temp == "<":
        flag = 1
        answer += init[::-1]
        init = ""
        answer += temp

    elif temp == ">":
        flag = 0
        answer += temp

    else:
        if flag:
            answer += temp

        elif temp == " ":
            answer += init[::-1] + " "
            init = ""
        else:
            init += temp

    if len(s) == 0:
        answer += init[::-1]

print(answer)
