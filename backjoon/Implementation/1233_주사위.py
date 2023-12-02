s1, s2, s3 = map(int, input().split())
d = {}
for i in range(1, s1+1):
    for j in range(1, s2+1):
        for k in range(1, s3+1):
            d[i+j+k] = d.get(i+j+k, 0) + 1
li = sorted(d.items(), key=lambda x:x[0])
li = sorted(li, key=lambda x:x[1], reverse=True)
print(li[0][0])