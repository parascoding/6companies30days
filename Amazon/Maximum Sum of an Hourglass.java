class Solution {
    public int maxSum(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int max = 0;
        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-2;j++){
                max = Math.max(max, find(a, i, j));
            }
        }
        return max;
    }
    static int find(int a[][], int i, int j){
        return a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+1]+a[i+2][j]+a[i+2][j+1]+a[i+2][j+2];
    }
}
