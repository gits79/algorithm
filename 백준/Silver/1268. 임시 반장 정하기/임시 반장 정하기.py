import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

# 학생별 같은 반 경험 횟수를 저장할 리스트
answer = [0] * n

# 각 학생들 간 같은 반이었던 횟수를 카운트
for i in range(n):
    for j in range(n):
        if i != j:
            for k in range(5):
                if arr[i][k] == arr[j][k]:
                    answer[i] += 1
                    break

# 가장 많은 같은 반 경험을 가진 학생의 인덱스 찾기
max_count = max(answer)
leader = answer.index(max_count) + 1

print(leader)
