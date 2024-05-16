import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

answer = [0] * n

for i in range(n):
    for j in range(n):
        if i != j:
            for k in range(5):
                if arr[i][k] == arr[j][k]:
                    answer[i] += 1
                    break

max_count = max(answer)
leader = answer.index(max_count) + 1

print(leader)
