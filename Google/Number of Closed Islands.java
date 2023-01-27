class Solution {
    public int closedIsland(int[][] a) {
        n = a.length;
        m = a[0].length;
        for(int i = 0; i < n; i++){
            if(a[i][0] == 0)
                bfs(a, i, 0);
            if(a[i][m - 1] == 0)
                bfs(a, i, m - 1);
        }
        for(int j = 0; j < m; j++){
            if(a[0][j] == 0)
                bfs(a, 0, j);
            if(a[n - 1][j] == 0)
                bfs(a, n -1, j);
        }
        // print(a);
        int ans = 0;
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < m - 1; j++){
                if(a[i][j] == 0){
                    bfs(a, i, j);
                    ans++;
                    // System.out.println(i + " " + j);
                }
                    
            }
        }
        return ans;
    }
    static void print(int a[][]){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                System.out.print(a[i][j]);
            System.out.println();
        }
    }
    static void bfs(int a[][], int i, int j){
        Queue<int[]> q = new LinkedList<>();
        // int size = 1;
        q.add(new int[]{i, j});
        a[i][j] = 2;
        while(!q.isEmpty()){
            int temp[] = q.poll();
            // size++;
            int x = temp[0], y = temp[1];
            for(int k = 0; k < 4; k++){
                int xi = x + dx[k];
                int xj = y + dy[k];
                if(isSafe(xi, xj) && a[xi][xj] == 0){
                    q.add(new int[]{xi, xj});
                    a[xi][xj] = 2;
                }
            }
        }
        // return size;
    }
    static boolean isSafe(int i, int j){
        return i > -1 && i < n && j > -1 && j < m;
    }
    static int dx[] = {-1, 0, 0, 1};
    static int dy[] = {0, -1, 1, 0};
    static int n, m;
    
}
