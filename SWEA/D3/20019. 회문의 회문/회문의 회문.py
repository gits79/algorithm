def solution(S):

    N = len(S)
    if S == S[::-1]:
        if S[:N//2] == S[:N//2][::-1] and S[N//2+1:] == S[N//2+1:][::-1]:
            return 'YES'
    else:
        return 'NO'
    return 'NO'

T = int(input())
for testcase in range(1, T+1):
    S = input()
    answer = solution(S)
    print(f'#{testcase} {answer}')