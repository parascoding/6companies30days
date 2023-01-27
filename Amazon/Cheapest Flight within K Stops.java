class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int e[] : edges){
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }
        int dist[] = new int[n];
        Arrays.fill(dist, inf);
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        dist[src] = 0;
        while(count++ <= k && !q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int temp[] = q.poll();
                for(int ngr[] : adj.get(temp[0])){
                    if(dist[ngr[0]] <= temp[1] + ngr[1])
                        continue;
                    dist[ngr[0]] = temp[1] + ngr[1];    
                    q.add(new int[]{ngr[0], temp[1] + ngr[1]});
                }
            }
        }
        if(dist[dst] == inf)
            return -1;
        return dist[dst];

    }
    
    static Integer[][] memo;
    static int max = -1, inf = (int)1e6;
    static List<List<int[]>> adj;
}
