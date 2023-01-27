class Solution {
    public int[][] matrixBlockSum(int[][] a, int k) {
        int n = a.length, m = a[0].length;
        
        for(int j = 0; j < m; j++){
            for(int i = 1; i < n; i++)
                a[i][j] += a[i - 1][j];
        }
        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                a[i][j] += a[i][j - 1];
            }
        }
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++)
        //         System.out.print(a[i][j] +" ");
        //     System.out.println();
        // }
        int ans[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = findSum(a, Math.max(0, i - k), Math.max(0, j - k), Math.min(n - 1, i + k), Math.min(m - 1, j + k));
            }
        }
        return ans;
    }
    static int findSum(int a[][], int x1, int y1, int x2, int y2){
        int sum = a[x2][y2];
        if(x1 > 0)
            sum -= a[x1 - 1][y2];
        if(y1 > 0)
            sum -= a[x2][y1 - 1];
        if(x1 > 0 && y1 > 0)
            sum += a[x1 - 1][y1- 1];
        return sum;
    }
}
