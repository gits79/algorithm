import sys
input = lambda : sys.stdin.readline().strip()

a, b = map(str, input().split())

if a in b:
    print(0)
else:
    answer = []
    for i in range(len(b) - len(a) + 1):
        count = 0
        temp = b[i:i+len(a)]
        for j in range(len(a)):
            if a[j] == temp[j]:
                count += 1
        answer.append(count)
    
    print(len(a) - max(answer))
