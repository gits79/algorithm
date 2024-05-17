import sys
from collections import deque
input = lambda : sys.stdin.readline().strip()

s = input()
n = len(s)
select = deque()
visited = [False] * (n + 1)
answer = set()


def recur(cur):
    if cur == n:
        flag = True
        lst = ["1"]
        deq = select.copy()
        while deq:
            temp = deq.popleft()
            if temp != lst[-1]:
                lst.pop()
                lst.append(temp)
            else:
                flag = False
                break
        if flag:
            answer.add(''.join(select))
        return

    for i in range(n):
        if visited[i]:
            continue
        select.append(s[i])
        visited[i] = True
        recur(cur + 1)
        visited[i] = False
        select.pop()

recur(0)
print(len(answer))
