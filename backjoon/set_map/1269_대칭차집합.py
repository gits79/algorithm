n, m = map(int, input().split())

set1 = set(map(int, input().split()))
set2 = set(map(int, input().split()))

count = 0
count += len(set1 - set2)
count += len(set2 - set1)

print(count)