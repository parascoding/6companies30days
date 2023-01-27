class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        a=dungeon;
        n=a.length;
        m=a[0].length;
        dp=new Integer[n][m];
        return solve(0,0);
    }
    static int solve(int i, int j){
        if(i==n||j==m) return Integer.MAX_VALUE;
        if(dp[i][j]!=null) return dp[i][j];
        
        if(i==n-1&&j==m-1){
            if(a[i][j]<=0)
                return 1-a[i][j];
            else
                return 1;
        }
        int down = solve(i+1, j);
        int right = solve(i, j+1);
        int min =Math.min(down, right)-a[i][j];
        if(min<=0){
            min =1;
        }
        return dp[i][j]=min;
    }
    static int n, m;
    static Integer dp[][];
    static int a[][];
}
