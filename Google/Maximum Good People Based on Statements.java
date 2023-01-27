class Solution {
    public int maximumGood(int[][] a) {
        int n = a.length;
        int max = 0;
        int temp = 0;
        for(int i = (1 << n) - 1; i > -1; i--){
            if(check(a, i, n)){
                int bits = findSetBits(i);
                if(bits > max){
                    max = bits;
                    temp = i;
                }
                // max = Math.max(max, findSetBits(i));
            }
        }
        System.out.println(temp);
        return max;
    }
    static int findSetBits(int mask){
        int count = 0;
        for(int i = 31; i > -1; i--)
            if((mask & (1 << i)) > 0)
                count++;
        return count;
    }
    static boolean check(int a[][], int mask, int n){
        int mark[] = new int[n];
        Arrays.fill(mark, -1);
        for(int i = 0; i < n; i++)
            if((mask & (1 << i)) > 0)
                mark[i] = 1;
            else
                mark[i] = 0;
        
        for(int i = 0; i < n; i++){
            if((mask & (1 << i)) > 0){
                for(int j = 0; j < n; j++){
                    if(a[i][j] != 2 && i != j){
                        if(mark[j] != a[i][j])
                            return false;
                        mark[j] = a[i][j];
                    }
                }
            }
        }
        return true;
    }
}
