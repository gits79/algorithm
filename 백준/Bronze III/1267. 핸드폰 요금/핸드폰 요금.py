n = int(input())

arr = list(map(int, input().split()))

answer = []
temp = 0
for i in arr:
    temp += i // 30 * 10
    if i % 30 >= 0:
        temp += 10


temp2 = 0
for i in arr:
    temp2 += i // 60 * 15
    if i % 60 >= 0:
        temp2 += 15

answer.append(temp)
answer.append(temp2)

if answer[0] > answer[1]:
    print("M", answer[1])
elif answer[0] < answer[1]:
    print("Y", answer[0])
else:
    print("Y M",answer[0])