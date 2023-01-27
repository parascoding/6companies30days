class Solution {
    public boolean increasingTriplet(int[] a) {
        int n = a.length;
        int right[] = new int[n];
        right[n - 1] = Integer.MIN_VALUE;
        for(int i = n - 2; i > -1; i--){
            right[i] = Math.max(a[i + 1], right[i + 1]);
        }
        int min = a[0];
        for(int i = 1; i < n - 1; i++){
            if(a[i] > min && a[i] < right[i])
                return true;
            min = Math.min(min, a[i]);
        }
        return false;
    }
}
