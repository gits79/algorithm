

# 입력 받기
A, B, D = map(int, input().split())

# 소수 체크할 배열
isPrime = [True] * (B+1)

# 1은 소수가 아님
isPrime[1] = False
# 에라토스테네스의 체
for i in range(2, int(B ** 0.5)+1):
    if isPrime[i]:
        for j in range(i, B):
            if i*j > B:
                break
            isPrime[i*j] = False

answer = 0
# A부터 B까지 수가 있는지 체크하기
for i in range(A, B+1):
    # 소수라면
    if isPrime[i]:
        N = i
        while N:
            if N % 10 == D:
                answer += 1
                break
            N //= 10
            
print(answer)