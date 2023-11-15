t = int(input())

for tc in range(1, t+1):
    day = input()
    if day == "SUN":
        print(f'#{tc} 7')
    else:

        week = ["","MON","TUE","WED","THU","FRI","SAT","SUN"]

        for i in range(8):
            if day == week[i]:
                print(f'#{tc} {7 - i}')