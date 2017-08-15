'''Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.'''


# Your task is to complete this function
# Function should return True/False or 1/0
# Graph(graph) is a defaultict of type List
# n is no of Vertices's
 
def find_parent(parent,i):
    if parent[i] == -1:
        return i
    if parent[i]!= -1:
        return find_parent(parent,parent[i])

def union(parent,x,y):
    x_set = find_parent(parent, x)
    y_set = find_parent(parent, y)
    parent[x_set] = y_set

def isCyclic(n, graph):
  
    parent = [-1]*(n)

    for i in graph:
        for j in graph[i]:
            x = find_parent(parent, i) 
            y = find_parent(parent, j)
            if x == y:
                return True
            union(parent,x,y)
    
    return False