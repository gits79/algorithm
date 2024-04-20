import sys
input = lambda: sys.stdin.readline().strip()

def game_change(str):
    if str == "Y":
        return 1
    elif str == "F":
        return 2
    else:
        return 3

n, game = map(str, input().split())
lst = set()
for _ in range(int(n)):
    lst.add(input())

print(len(lst) // game_change(game))
