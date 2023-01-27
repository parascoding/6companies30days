class Solution {
    public int findUnsortedSubarray(int[] a) {
        int n = a.length;
       
        int low = -1, high = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(a[i] < max){
                high = i;
            }
            max = Math.max(max, a[i]);
        }
        int min = Integer.MAX_VALUE;
        for(int i = n - 1; i > -1; i--){
            if(a[i] > min){
                low = i;
            }
            min = Math.min(min, a[i]);
        }
        
        if(low == -1)
            return 0;
        return high - low + 1;
    }
}
