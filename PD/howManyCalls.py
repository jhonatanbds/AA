def calls(n, mem):
    if n < 2:
    	return 1
    elif mem[n] > 0:
        return mem[n]
    else:
    	mem[n] = 1 + calls(n-1, mem) + calls(n-2, mem)
    	return mem[n]

def frib(n, mem):
    if n < 2:
        return n
    elif mem[n] > 0:
        return mem[n]
    else:
        mem[n] = frib(n-1, mem) + frib(n-2, mem)
        return mem[n]
        
t = int(input())
for i in range(t):
    n = int(input())
    mem = [0 for i in range(50)]
    mem2 = [0 for i in range(50)]
    print("fib(%d) = %d calls = %d" % (n, calls(n, mem) - 1, frib(n,mem2)))
