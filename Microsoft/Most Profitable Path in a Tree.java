class Solution {
    public int mostProfitablePath(int[][] e, int bob, int[] a) {
        adj = new ArrayList<>();
        int n = a.length;
        par = new int[n];
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int x[] : e){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
        dfs(0, -1);
        
        int t = 0;
        time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        while(bob != -1){
            time[bob] = t++;
            bob = par[bob];
        }
        max = Integer.MIN_VALUE;
        if(time[0] == 0)
            dfs2(0, -1, a[0] /  2, a, 0);
        else
            dfs2(0, -1, a[0], a, 0);
        return max;
    }
    private void dfs2(int node, int parent, int cost, int a[], int curTime){
        if(adj.get(node).size() == 1 && adj.get(node).get(0) == parent){
            max = Math.max(max, cost);
            return;
        }
        for(int ngr : adj.get(node)){
            if(ngr != parent){
                if(time[ngr] > curTime + 1){
                    dfs2(ngr, node, cost + a[ngr], a, curTime + 1);
                } else if(time[ngr] == curTime + 1){
                    dfs2(ngr, node, cost + a[ngr] / 2, a, curTime + 1);
                } else{
                    dfs2(ngr, node, cost, a, curTime + 1);
                }
            }
        }
    }
    private void dfs(int node, int parent){
        par[node] = parent;
        for(int ngr : adj.get(node)){
            if(ngr != parent){
                dfs(ngr, node);
            }
        }
    }
    int max;
    int time[];
    int par[];
    List<List<Integer>> adj;
}
