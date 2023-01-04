class Solution {
    public int minOperations(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int g = b[0];
        for(int i = 0; i < m; i++)
            g = gcd(g, b[i]);
        Arrays.sort(a);
        for(int i = 0; i < n; i++){
            if(g % a[i] == 0)
                return i;
        }
        return -1;
    }
    static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
}
