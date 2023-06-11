

def cantona(s):
    if len(s) < 3:
        return s
    size = len(s) // 3

    cantona(s[0:size])

    for i in range(size,2*size):
        s[i] = " "

    cantona(s[size*2:len(s)])


n = int(input())

max_score = ["-"] * (3 ** n)
print(cantona(max_score))
print(max_score)