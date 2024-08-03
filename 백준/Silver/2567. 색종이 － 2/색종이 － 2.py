def count(arr):
    cnt = 0
    for lst in arr:
        for i in range(1, len(lst)):
            if lst[i-1] != lst[i]:
                cnt+=1
    return cnt

N = int(input())
arr = [[0]*102 for _ in range(102)]
for _ in range(N):
  
    sj, si = map(int, input().split())
    for i in range(si, si+10):
        for j in range(sj, sj+10):
            arr[i][j] = 1
arr_t = list(zip(*arr))
ans = count(arr) + count(arr_t)
            
print(ans)