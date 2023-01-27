class Solution {
    public int swimInWater(int[][] a) {
        int n = a.length;
        int low = a[0][0], high = n * n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(check(a, n, mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    private boolean check(int a[][], int n, int mid){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean visited[][] = new boolean[n][n];
        visited[0][0] = true;
        while(!q.isEmpty()){
            int temp[] = q.poll();
            if(temp[0] == n - 1 && temp[1] == n - 1)
                return true;
            for(int k = 0; k < 4; k++){
                int xi = temp[0] + dx[k];
                int xj = temp[1] + dy[k];
                if(isSafe(xi, xj, n) && !visited[xi][xj] && a[xi][xj] <= mid){
                    q.add(new int[]{xi, xj});
                    visited[xi][xj] = true;
                }
            }
        }
        return false;
    }
    private boolean isSafe(int i, int j, int n){
        return i > -1 && i < n && j > -1 && j < n;
    }
    public int dx[] = {-1, 0, 0, 1};
    public int dy[] = {0, -1, 1, 0};
}
