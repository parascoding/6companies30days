class Solution {
    public double knightProbability(int n, int k, int r, int c) {
        memo = new Double[n + 1][n + 1][k + 1];
        return dfs(n, k, r, c);
    }
    private double dfs(int n, int k, int r, int c){
        if(!isSafe(r, c, n))
            return 0.0;
        if(k == 0)
            return 1.0;
        if(memo[r][c][k] != null)
            return memo[r][c][k];
        double prob = 0;
        for(int i = 0; i < 8; i++){
            prob += (dfs(n, k - 1, r + dx[i], c + dy[i])) / 8.0;
        }
        return memo[r][c][k] = prob;
    }
    private boolean isSafe(int i, int j, int n){
        return i > -1 && i < n && j > -1 && j < n;
    }
    static Double memo[][][];
    private int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
    private int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
}
