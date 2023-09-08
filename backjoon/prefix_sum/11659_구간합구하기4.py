n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.insert(0, 0)
arr.insert(n + 1, 0)

prefix_sum = [0] * (n + 2)
for i in range(1, n + 1):
    prefix_sum[i] = prefix_sum[i - 1] + arr[i]

for k in range(m):
    i, j = map(int, input().split())
    print(prefix_sum[j] - prefix_sum[i - 1])
