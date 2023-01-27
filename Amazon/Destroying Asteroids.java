class Solution {
    public boolean asteroidsDestroyed(int M, int[] a) {
        long m = M;
        Arrays.sort(a);
        for(int x : a){
            if(m < x)
                return false;
            m += x;
        }
        return true;
    }
}
