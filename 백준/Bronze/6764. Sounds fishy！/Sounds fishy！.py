a = []
for i in range(4) :
    a.append(int(input()))
n = 0

for i in range(3):
    if a[i+1] > a[i]:
        n = n + 1
    elif a[i+1] < a[i]:
        n = n - 1

if len(set(a)) == 1: 
    print("Fish At Constant Depth")
elif n == 3:
    print("Fish Rising")
elif n == -3:    
    print("Fish Diving")
else:
    print("No Fish")