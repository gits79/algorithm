import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
arr = [input() for _ in range(n)]

def count_places(array, n):
    count = 0
    for line in array:
        empty_space = 0
        for char in line:
            if char == '.':
                empty_space += 1
            else:
                if empty_space >= 2:
                    count += 1
                empty_space = 0
        if empty_space >= 2:
            count += 1
    return count


horizontal_count = count_places(arr, n)

transposed_arr = list(map(''.join, zip(*arr)))
vertical_count = count_places(transposed_arr, n)

print(horizontal_count, vertical_count)
