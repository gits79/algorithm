
def is_prime(n):
    for i in range(2,int(n**0.5)+1):
        if n % i == 0:
            return False

    return True



t = int(input())

for p in range(1,t+1):

    n , cal = map(int,input().split())

    arr = []
    result = []

    for _ in range(n):
        temp = list(map(int,input().split()))
        arr.append(temp)

    arr.sort(reverse=True)
    for i in range(len(arr)):
        favor = arr[i][0]
        sum = arr[i][1]
        for j in range(len(arr)):
            if sum + arr[j][1] <= cal and i != j:
                sum += arr[j][1]
                favor += arr[j][0]
        result.append(favor)

    print(f'#{p} {max(result)}')