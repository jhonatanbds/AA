'''Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.'''


# your task is to complete this function
# Function should return sum of weights of  the edges of the Minimum Spanning Tree
# graph is of form adjancy matrix
# e is the number of edges and n is the no of nodes

def parent(p, u):
    if p[u] == -1:
        return u
    return parent(p, p[u])

def union(p, u, v):
    pu = parent(p, u)
    pv = parent(p, v)
    p[pv] = pu

def cycle(p, u, v):
    return parent(p, u) == parent(p, v)

def spanningTree(graph, n, e):
    edges = []
    p = []

    for u in range(0, n):
        p.append(-1)
    
    for u in range(0, n):
        for v in range(u+1, n):
            w = graph[u][v] 
            if w > 0:
                edges.append((u+1, v+1, w))

    sortedEdges = sorted(edges, key=lambda i: i[2])
    
    sum = 0

    for e in sortedEdges:
        u = e[0]
        v = e[1]
        w = e[2]
        if not cycle(p, u, v):
            union(p, u, v)
            sum += w
    
    return sum