# # x^2 + 2Ax + B = 0
#
# A, B = map(int, input().split())
# # a * b = B
# # a + b = 2A
#
# result = []
# for a in range(-1000, 1000):
#     if a == 0:
#         continue
#
#     if B == 0:
#         print(0)
#         break
#
#     if B > 0:
#         if A < 0 and B ** 0.5 == int(B ** 0.5):
#             print(int(B ** 0.5))
#             break
#         elif A > 0 and B ** 0.5 == int(B ** 0.5):
#             print(int(B ** 0.5) * -1)
#             break
#     elif B < 0 and A == 0:
#         B *= -1
#         b = int(B ** 0.5)
#         print(b * -1, b)
#
#
#     if B % a == 0:
#         b = int(B / a)
#         if a + b == -2 * A:
#             result.append(a)
#             result.append(b)
#             result.sort()
#             print(*result[:])
#             break

# x^2 + 2Ax + B = 0

A, B = map(int, input().split())

x = int(-1 * A + (A ** 2 - B) ** 0.5)
y = int(-1 * A - (A ** 2 - B) ** 0.5)

if x == y:
    print(x)
if x > y:
    print(y,x)
