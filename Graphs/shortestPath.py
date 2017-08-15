def solution(n):
    if n == 1:
        return 0
    elif n % 3 == 0:
        return 1 + solution(n/3)
    else:
        return 1 + solution(n-1)

n = int(input())
for i in range(n):
    print(solution(int(input())))