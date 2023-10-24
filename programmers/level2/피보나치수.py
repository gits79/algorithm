import sys
input = lambda : sys.stdin.readline().strip()

def solution(n):
    answer = 0
    d = [0] * 100_001
    d[0] = 0
    d[1] = 1

    for i in range(2,100_001):
        d[i] = (d[i - 1] + d[i - 2]) % 1234567
    answer = d[n]
    return answer

print(solution(100_000))