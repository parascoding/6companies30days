class Solution {
    public int peopleAwareOfSecret(int n, int d, int f) {
        int a[] = new int[n];
        a[0] = 1;
        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= i - f && j > -1; j--){ 
                a[i] += a[j];
            }
        }
        return a[n - 1];
    }
}
