t = int(input())

for p in range(t):

    n, k = map(int, input().split())
    student = []
    student_score = []
    score = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]

    for z in range(n):
        mid, final, assi = map(int, input().split())
        sum = mid * 0.35 + final * 0.45 + assi * 0.2
        student.append([sum, z, ""])

    student.sort()

    for i in range(len(score)):
        for j in range(n // 10):
            temp_student = student.pop()
            temp_student[2] = score[i]
            student_score.append(temp_student)

    student_score.sort(key=lambda x:x[1])


    print(f'#{p + 1} {student_score[k-1][2]}')