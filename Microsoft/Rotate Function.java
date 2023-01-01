class Solution {
    public int maxRotateFunction(int[] a) {
        int n = a.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n - 1; i++)
            sum += a[i];
        int val = 0;
        for(int i = 0; i < n; i++)
            val += a[i] * i;
        max = Math.max(max, val);
        int ind = n - 1;
        for(int i = 1; i < n; i++, ind--){
            val -= a[ind] * (n - 1);
            val += sum;
            sum += a[ind];
            if(ind > 0)
                sum -= a[ind - 1];
            max = Math.max(max, val);
        }
        return max;
        
    }
}
