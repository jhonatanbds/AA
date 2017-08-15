def fib(n, mem):
    for i in range(2, n+1):
        mem.append(mem[i-1] + mem[i-2])
        
t = int(input())
for i in range(t):
    n = int(input())
    mem = []
    mem.append(0)
    mem.append(1)
    fib(n, mem)
    print(mem[n]%1000000007)