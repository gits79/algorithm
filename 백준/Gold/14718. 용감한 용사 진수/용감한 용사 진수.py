import sys
input = lambda: sys.stdin.readline().strip()

n, c = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

answer = [1000000, 1000000, 1000000]

for i in range(n):
    for j in range(n):
        for k in range(n):
            str = arr[i][0]
            dex = arr[j][1]
            intt = arr[k][2]
            count = 0

            for l in range(n):
                if arr[l][0] <= str and arr[l][1] <= dex and arr[l][2] <= intt:
                    count += 1

            if count >= c:

                if sum(answer) > str + dex + intt:
                    answer[0] = str
                    answer[1] = dex
                    answer[2] = intt

print(sum(answer))
