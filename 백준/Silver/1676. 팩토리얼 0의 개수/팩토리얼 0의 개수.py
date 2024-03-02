import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = [1] * 502

for i in range(1,n + 1):
    arr[i] = i * arr[i-1]

count = 0
s = str(arr[n])
s = s[::-1]

for i in s:
    if i == "0":
        count += 1
    else:
        break

print(count)
