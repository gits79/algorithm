def solution(people, limit):
    answer = 0
    people.sort()
    left = 0
    right = len(people) - 1

    while left <= right:
        temp = people[left] + people[right]

        if temp <= limit:
            left += 1
            right -= 1

        elif temp > limit:
            right -= 1

        answer += 1

    return answer
