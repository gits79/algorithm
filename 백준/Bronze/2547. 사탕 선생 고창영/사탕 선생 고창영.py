import sys
input = sys.stdin.readline


T = int(input())
for _ in range(T):
    _ = input()  
    N = int(input())
    candy = 0
    for _ in range(N):
        candy += int(input())
    if candy % N == 0:
        print("YES")
    else:
        print("NO")