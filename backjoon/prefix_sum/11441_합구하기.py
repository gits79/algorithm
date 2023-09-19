import sys
input = sys.stdin.readline

n = int(input())
arr = [0] + list(map(int, input().split())) + [0]
m = int(input())
prefix_sum = [0] * (n + 2)

for i in range(1, n + 1):
    prefix_sum[i] = prefix_sum[i - 1] + arr[i]

for _ in range(m):
    i, j = map(int, input().split())
    print(prefix_sum[j] - prefix_sum[i - 1])
