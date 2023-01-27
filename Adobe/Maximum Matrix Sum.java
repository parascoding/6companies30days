class Solution {
    public long maxMatrixSum(int[][] a) {
        long sum = 0;
        int xor = 0;
        int min = Integer.MAX_VALUE;
        for(int x[] : a){
            for(int y : x){
                if(y < 0){
                    xor ^= 1;
                }
                sum += Math.abs(y);
                min = Math.min(min, Math.abs(y));
            }
        }
        if(xor == 0)
            return sum;
        return sum - 2 * min;
    }
}
