print("Gnomes:")
for _ in range(int(input())) :
    lst = list(map(int, input().split()))
    result = True
    if (lst[2] - lst[1] >= 0 and lst[1] - lst[0] >= 0) or (lst[2] - lst[1] < 0 and lst[1] - lst[0] < 0) : print("Ordered")
    else : print("Unordered")
