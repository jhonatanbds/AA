/*Complete the function below*/
class GfG {
	public static boolean isBipartite(int G[][],int src,int V) {
        GfG g=new GfG();
        int[] c=new int[V];
        for(int i=0;i<V;i++)
            c[i]=-1;
        c[src]=0;
        return g.bfs(G,src,V,c);
    }
    
    boolean bfs(int[][] m, int s, int n, int[] c){
        LinkedList<Integer> q=new LinkedList<Integer>();
        q.add(s);
        while(q.size() != 0){
            int actual = q.poll();
            for(int i=0;i<n;i++){
                if(m[actual][i]==1 && c[i]==-1){
                    c[i]=1-c[actual];
                    q.add(i);
                }
                else{
                    if(m[actual][i]==1 && c[actual]==c[i])
                        return false;
                }
            }
        }
        return true;
    }
}