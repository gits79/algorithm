p = list(map(int, input().split(':')))
r = list(map(int, input().split(':')))
result=[]

t = r[0] * 3600 + r[1] * 60 + r[2] - (p[0] * 3600 + p[1] * 60 + p[2])

if t < 0:
    t += 60*60*24

result.append(t//3600)
result.append((t%3600)//60)
result.append(t%60)

for i in range(3):
    result[i] = str(result[i]).zfill(2)

print('%s:%s:%s'%(result[0],result[1],result[2]))