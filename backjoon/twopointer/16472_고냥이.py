import sys
input = sys.stdin.readline

n = int(input())
s = input().strip()

left = 0
right = 0
answer = ""
arr = [0] * 200
result = []

while True:

    temp = s[right]
    answer += temp
    arr[ord(temp)] = 1

    if sum(arr) > n:
        count = 0
        while sum(arr) > n:
            count += 1
            temp2 = answer[0:1]
            answer = answer[1:]
            if temp2 not in answer:
                arr[ord(temp2)] = 0

        left += count
        right += 1
        result.append(len(answer))
        if right == len(s):
            break
    else:
        right += 1
        result.append(len(answer))
        if right == len(s):
            break

print(max(result))
