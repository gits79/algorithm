def isPrime(n):

    for i in range(2,n):
        if n % i == 0:
            return False
    return True
arr1 = []
arr2 = [3,5,7,11]

for j in range(1,1000000):
    print(j)


# for i in range(3,1001,2):
#     if i % 3 != 0 and i % 5 != 0 and i %7 != 0 and i% 11 != 0:
#         # print(i)
#         arr2.append(i)

print(arr1)
print(arr2)
print(arr1==arr2)
