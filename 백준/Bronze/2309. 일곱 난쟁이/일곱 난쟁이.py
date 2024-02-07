import sys
input = lambda : sys.stdin.readline().strip()

arr = []
for i in range(9):
    arr.append(int(input()))
arr.sort()
answer = []


for i in range(9):
    for j in range(i + 1,9):
        temp = arr.copy()
        # if i == j:
        #     continue
        temp.remove(arr[i])
        temp.remove(arr[j])
        if sum(temp) == 100:
            answer = temp.copy()
            break
answer.sort()
for i in answer:
    print(i)

