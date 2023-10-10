import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
grade = "F"

if n >= 90:
    grade = "A"
elif n >= 80:
    grade = "B"
elif n >= 70:
    grade = "C"
elif n >= 60:
    grade = "D"

print(grade)