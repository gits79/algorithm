import sys
input = lambda: sys.stdin.readline().strip()

while True:
    s = input()
    s = s.lower()
    if s == "#":
        break
    count = 0

    alp = ["a","e","i","o","u"]

    for i in alp:
        count += s.count(i)

    print(count)