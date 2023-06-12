
def dfs(idx,m,arr,count,result):
    if idx == n:
        print(arr[idx])
        return

    if count == m:
        print(arr[idx])
        return
    result.append(arr[idx])

    dfs(idx+1,m,arr,count+1,result)




n, m = map(int,input().split())
arr = [i+1 for i in range(n)]
result = []
dfs(0,m,arr,0,result)
print(result)