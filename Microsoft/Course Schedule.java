class Solution {
    public boolean canFinish(int n, int[][] a) {
        int deg[] = new int[n];
        adj = new ArrayList<>();
        for(int i = 0;  i < n; i++)
            adj.add(new ArrayList<>());
        for(int x[] : a){
            deg[x[1]]++;
            adj.get(x[0]).add(x[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
            if(deg[i] == 0)
                q.add(i);
        int count = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            count++;
            for(int ngr : adj.get(temp))
                if(--deg[ngr] == 0){
                    q.add(ngr);
                }
        }
        return count == n;
    }
    static List<List<Integer>> adj;
}
