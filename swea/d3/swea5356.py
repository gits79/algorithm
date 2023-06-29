t = int(input())

for p in range(1,t+1):
    arr = []

    for _ in range(5):
        s = input() + " " * 15
        arr.append(s)

    max_score = ""
    for i in range(15):
        for j in range(5):
            max_score += arr[j][i]
    max_score = max_score.replace(" ", "")

    print(f'#{p} {max_score}')

