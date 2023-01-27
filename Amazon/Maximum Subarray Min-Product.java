class Solution {
    public int maxSumMinProduct(int[] a) {
        int n = a.length;
        int left[] = new int[n], right[] = new int[n];
        right[n - 1] = n;
        for(int i = n - 2; i > -1; i--){
            int p = i + 1;
            while(p < n && a[p] >= a[i]){
                p = right[p];
            }
            right[i] = p;
        }
        left[0] = -1;
        for(int i = 1; i < n; i++){
            int p = i - 1;
            while(p > -1  && a[p] >= a[i]){
                p = left[p];
            }
            left[i] = p;
        }
        long pre[] = new long[n];
        pre[0] = a[0];
        for(int i = 1; i < n; i++)
            pre[i] = pre[i - 1] + a[i];
        long ans = 0;
        for(int i = 0; i < n; i++){
            int l = left[i], r = right[i];
            l++;
            r--;
            long sum = pre[r] - (l == 0 ? 0 : pre[l - 1]);
            
            ans = Math.max(ans, sum * a[i]);
        }
        
        return (int)(ans % (int)(1e9 + 7));
    }
}
