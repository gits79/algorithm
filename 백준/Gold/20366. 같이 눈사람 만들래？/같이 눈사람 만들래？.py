import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
arr = list(map(int, input().split()))
arr.sort()
answer = max(arr) * 10

for i in range(n - 3):
    for j in range(i + 3, n):
        left = i + 1
        right = j - 1
        a = arr[i] + arr[j]

        while left < right:
            b = arr[left] + arr[right]

            if abs(a - b) < answer:
                answer = abs(a-b)

            if a > b:
                left += 1
            elif a < b:
                right -= 1
            else:
                print(0)
                sys.exit(0)

print(answer)