# from itertools import combinations, permutations
#
# t = int(input())
#
# for p in range(1,t+1):
#     n, k = map(int,input().split())
#     arr = list(map(int,input().split()))
#
#
#     combi = []
#     for i in range(1,len(arr)):
#         combi.append(list(combinations(arr,i)))
#     count = 0
#     for i in combi:
#         for j in i:
#             if sum(j) == k:
#                 count += 1
#     print(f'#{p} {count}')
#

# def dfs(idx, current_sum):
#     global count
#
#     if current_sum == K:  # 합이 K와 일치하는 경우
#         count += 1
#
#     if idx >= N:  # 인덱스 범위를 벗어난 경우
#         return
#
#     # 현재 원소를 선택하는 경우
#     dfs(idx + 1, current_sum + A[idx])
#
#     # 현재 원소를 선택하지 않는 경우
#     dfs(idx + 1, current_sum)
#
#
# T = int(input())  # 테스트 케이스 수
#
# for t in range(1, T + 1):
#     N, K = map(int, input().split())  # 자연수의 개수 N과 목표 합 K
#     A = list(map(int, input().split()))  # 자연수 수열 A
#     count = 0  # 부분 수열의 합이 K와 일치하는 경우의 수 초기화
#
#     dfs(0, 0)  # DFS를 이용하여 부분 수열 계산
#
#     print("#{} {}".format(t, count))  # 결과 출력




def dfs(arr,idx,sum,k):
    if sum == k:
        return

    dfs(arr,idx+1,sum+arr[idx],k)
    dfs(arr,idx+1,sum,k)



print(dfs([1,2,1,2],0,0,3))