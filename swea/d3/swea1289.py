
t = int(input())

def reverse(s):
    if s == "1":
        return "0"
    return "1"

for p in range(1,t+1):

    s = list(input())
    max_score = "0" * len(s)
    count = 0

    for i in range(len(s)):
        if s == max_score:
            break
        elif s[i] == "1":
            for j in range(i,len(s)):
                s[j] = reverse(s[j])

            count += 1

    print(f'#{p} {count}')
