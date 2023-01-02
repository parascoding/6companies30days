class Solution {
    public long numberOfPairs(int[] a1, int[] a2, int k) {
        int n = (int)(1e5 + 10);
        seg = new int[4 * n];
        long count = 0;
        for(int i = a1.length - 1; i > -1; i--){
            count += find(0, n - 1, a1[i] - a2[i] + del, n - 1, 0);
            update(0, n - 1, a1[i] - a2[i] + k + del, 0);
        }
        return count;
    }
    private int find(int low, int high, int l, int r, int node){
        if(low > r || high < l)
            return 0;
        if(low == high){
            return seg[node];
        }
        if(low >= l && high <= r)
            return seg[node];
        int mid = (low + high) / 2;
        return find(low, mid, l, r, 2 * node + 1) + find(mid + 1, high, l, r, 2 * node + 2);
    }
    private void update(int low, int high, int ind, int node){
        if(low == high){
            seg[node]++;
            return;
        }
        int mid = (low + high) / 2;
        if(ind <= mid)
            update(low, mid, ind, 2 * node + 1);
        else
            update(mid + 1, high, ind, 2 * node + 2);
        seg[node] = seg[2 * node + 1]  + seg[2 * node + 2];
    }
    int seg[];
    int del = (int)(2.5e4);
}

