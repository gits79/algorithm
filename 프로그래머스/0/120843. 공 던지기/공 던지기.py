def solution(numbers, k):
    answer = 0
    arr = numbers * 1000
    answer = arr[k*2-2]
    # print(arr[k*2-2])
    return answer