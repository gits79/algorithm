arr = []
for _ in range(10):
    arr.append(int(input()))

result = []

for i in range(1, 11):
    result.append(sum(arr[0:i]))
# -
answer1 = []
# +
answer2 = []
for i in result:
    if i - 100 < 0:
        answer1.append(i - 100)
    else:
        answer2.append(i - 100)

# answer2 가 빈 경우

if max(result) < 100:
    print(max(result))
elif min(result) > 100:
    print(min(result))
else:

    if 100 in result:
        print(100)

    elif max(answer1) * -1 > min(answer2) or max(answer1) * -1 == min(answer2):
        print(min(answer2) + 100)
    elif max(answer1) * -1 < min(answer2):
        print(max(answer1) + 100)
