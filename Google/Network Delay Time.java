class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for(int e[] : edges){
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(
            new Comparator<int[]>(){
                public int compare(int x[], int y[]){
                    return x[1] - y[1];
                }
            }
        );
        q.add(new int[]{k, 0});
        boolean visited[] = new boolean[n + 1];
        int max = 0;
        int count = 0;
        while(!q.isEmpty()){
            int temp[] = q.poll();
            if(visited[temp[0]])
                continue;
            visited[temp[0]] = true;
            max = Math.max(max, temp[1]);
            // System.out.println(temp[0] +" "+temp[1]);
            count++;
            for(int ngr[] : adj.get(temp[0])){
                if(!visited[ngr[0]]){
                    q.add(new int[]{ngr[0], temp[1] + ngr[1]});
                }
            }
        }
        if(count < n)
            return -1;
        return max;
    }
    static List<List<int[]>> adj;
}
