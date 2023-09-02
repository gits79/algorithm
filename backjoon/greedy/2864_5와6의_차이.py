def transfer(n, m):
    temp = ""
    for i in str(n):
        if i == "5" or i == "6":
            temp += str(m)
        else:
            temp += i
    return int(temp)


a, b = map(int, input().split())
answer = []

answer.append(a + b)
answer.append(transfer(a, 5) + transfer(b, 5))
answer.append(transfer(a, 6) + transfer(b, 6))
print(min(answer), max(answer))