class Solution {
    public int numberOfWays(int s, int e, int k) {
        s += k;
        e += k;
        dp = new Integer[3001][k + 1];
        return dfs(s, e, k);
    }
    static int dfs(int s, int e, int k){
        if(Math.abs(s - e) > k)
            return 0;
        if(k == 0){
            if(s == e)
                return 1;
            else 
                return 0;
        }
        if(dp[s][k] != null)
            return dp[s][k];
        int left = dfs(s - 1, e, k - 1);
        int right = dfs(s + 1, e, k - 1);
        return dp[s][k] = (left + right) % mod;
    }
    static Integer dp[][];
    static int mod = (int)(1e9 + 7);

}
